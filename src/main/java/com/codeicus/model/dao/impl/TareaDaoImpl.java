package com.codeicus.model.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.HttpMethod;

import com.codeicus.exception.TareaException;
import com.codeicus.model.dao.TareaDao;
import com.codeicus.model.dto.Tarea;
import com.codeicus.util.GsonDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@ApplicationScoped
public class TareaDaoImpl implements TareaDao {

	@Override
	public List<Tarea> findAll() {

		try {

			URL url = new URL(TareaDao.SERVICE_URI + "/tarea");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(HttpMethod.GET);
			int status = conn.getResponseCode();

			if(status == 200) {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				Gson gson = new Gson();
				Type tareaListType = new TypeToken<List<Tarea>>(){}.getType();

				List<Tarea> tareas = gson.fromJson(br, tareaListType);

				return tareas;

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Tarea findById(Integer id) {

		try {

			URL url = new URL(TareaDao.SERVICE_URI + "/tarea/" + id);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(HttpMethod.GET);
			int status = conn.getResponseCode();

			if(status == 200) {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				Gson gson = new Gson();
				Tarea tarea = gson.fromJson(br, Tarea.class);

				return tarea;

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;

	}

	@Override
	public void update(Tarea tarea) throws TareaException {
		
		try {
			
			Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new GsonDateAdapter()).create();

			String tareaJson = gson.toJson(tarea);
			
			HttpURLConnection conn = this.buildRestConnection(tareaJson, "/tarea", HttpMethod.PUT);
			int status = conn.getResponseCode();

			if(status != 200) throw new TareaException();

		} catch (IOException e) {

			e.printStackTrace();
			
			throw new TareaException();
		}

	}

	private HttpURLConnection buildRestConnection(String tareaJson, String uri, String httpMethod) throws IOException {
	
		URL url = new URL(TareaDao.SERVICE_URI + uri);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod(httpMethod);
		conn.setRequestProperty("Content-Type", "application/json");
		OutputStream os = conn.getOutputStream();
		os.write(tareaJson.getBytes());
		os.flush();
		
		return conn;
	}

	@Override
	public void create(Tarea tarea) throws TareaException {

		try {
			
			Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new GsonDateAdapter()).create();

			String tareaJson = gson.toJson(tarea);
			
			HttpURLConnection conn = this.buildRestConnection(tareaJson, "/tarea", HttpMethod.POST);
			int status = conn.getResponseCode();

			if(status != 201) throw new TareaException();

		} catch (IOException e) {

			e.printStackTrace();
			
			throw new TareaException();
		}
	}

	@Override
	public void delete(Tarea tarea) throws TareaException {

		try {
			
			Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new GsonDateAdapter()).create();

			String tareaJson = gson.toJson(tarea);
			
			HttpURLConnection conn = this.buildRestConnection(tareaJson, "/tarea", HttpMethod.DELETE);
			int status = conn.getResponseCode();

			if(status != 204) throw new TareaException();

		} catch (IOException e) {

			e.printStackTrace();
			
			throw new TareaException();
		}
	}
}
