/**
 * Copyright (C) 2012 MK124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.gtaun.shoebill.util.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author MK124
 */
public abstract class AbstractConfiguration implements Configuration
{
	public AbstractConfiguration()
	{
		
	}

	@Override
	public String getString(String path)
	{
		Object obj = getDefault(path);
		String def = obj != null ? getDefault(path).toString() : "";
		return getString(path, def);
	}
	
	@Override
	public String getString(String path, String def)
	{
		Object obj = get(path);
		return (obj == null) ? def : obj.toString();
	}
	
	@Override
	public void setString(String path, Object value)
	{
		set(path, value.toString());
	}
	
	@Override
	public boolean isString(String path)
	{
		return get(path) instanceof String;
	}
	
	@Override
	public int getInt(String path)
	{
		Integer def = 0;
		try
		{
			def = (Integer) getDefault(path);
		}
		catch (ClassCastException e)
		{
			
		}
		
		if (def == null) def = 0;
		return getInt(path, def);
	}
	
	@Override
	public int getInt(String path, int def)
	{
		Object obj = get(path);
		if (obj instanceof Integer) return (Integer)obj;
		if (obj instanceof Number) return Integer.parseInt(obj.toString());
		return def;
	}
	
	@Override
	public void setInt(String path, int value)
	{
		set(path, value);
	}
	
	@Override
	public boolean isInt(String path)
	{
		return get(path) instanceof Integer;
	}
	
	@Override
	public long getLong(String path)
	{
		Long def = 0L;
		try
		{
			def = (Long) getDefault(path);
		}
		catch (ClassCastException e)
		{
			
		}
		
		return getLong(path, def);
	}
	
	@Override
	public long getLong(String path, long def)
	{
		Object obj = get(path);
		if (obj instanceof Long) return (Long)obj;
		if (obj instanceof Number) return Long.parseLong(obj.toString());
		return def;
	}
	
	@Override
	public void setLong(String path, long value)
	{
		set(path, value);
	}
	
	@Override
	public boolean isLong(String path)
	{
		return get(path) instanceof Long;
	}
	
	@Override
	public float getFloat(String path)
	{
		Float def = Float.NaN;
		try
		{
			def = (Float) getDefault(path);
		}
		catch (ClassCastException e)
		{
			
		}
		
		return getFloat(path, def);
	}
	
	@Override
	public float getFloat(String path, float def)
	{
		Object obj = get(path);
		if (obj instanceof Float) return (Float)obj;
		if (obj instanceof Number) return Float.parseFloat(obj.toString());
		return def;
	}
	
	@Override
	public void setFloat(String path, float value)
	{
		set(path, value);
	}
	
	@Override
	public boolean isFloat(String path)
	{
		return get(path) instanceof Float;
	}
	
	@Override
	public double getDouble(String path)
	{
		Double def = Double.NaN;
		try
		{
			def = (Double) getDefault(path);
		}
		catch (ClassCastException e)
		{
			
		}
		
		return getDouble(path, def);
	}
	
	@Override
	public double getDouble(String path, double def)
	{
		Object obj = get(path);
		if (obj instanceof Double) return (Double)obj;
		if (obj instanceof Number) return Double.parseDouble(obj.toString());
		return def;
	}
	
	@Override
	public void setDouble(String path, double value)
	{
		set(path, value);
	}
	
	@Override
	public boolean isDouble(String path)
	{
		return get(path) instanceof Double;
	}
	
	@Override
	public boolean getBoolean(String path)
	{
		Boolean def = false;
		try
		{
			def = (Boolean) getDefault(path);
		}
		catch (ClassCastException e)
		{
			
		}
		
		return getBoolean(path, def);
	}
	
	@Override
	public boolean getBoolean(String path, boolean def)
	{
		Object obj = get(path);
		if (obj instanceof Boolean) return (Boolean)obj;
		if (obj instanceof Integer) return !obj.equals(0);
		return def;
	}
	
	@Override
	public void setBoolean(String path, boolean value)
	{
		set(path, value);
	}
	
	@Override
	public boolean isBoolean(String path)
	{
		return get(path) instanceof Boolean;
	}
	
	@Override
	public List<?> getList(String path)
	{
		return getList(path, null);
	}
	
	@Override
	public List<?> getList(String path, List<?> def)
	{
		Object o = get(path);
		if (o instanceof List) return (List<?>) o;
		if (def == null) def = new ArrayList<>(0);
		return def;
	}
	
	@Override
	public void setList(String path, List<?> value)
	{
		set(path, value);
	}
	
	@Override
	public boolean isList(String path)
	{
		return get(path) instanceof List;
	}
	
	@Override
	public List<String> getStringList(String path)
	{
		return getStringList(path, null);
	}
	
	@Override
	public List<String> getStringList(String path, List<String> def)
	{
		List<?> raw = getList(path);
		if (raw == null) return (def != null) ? def : new ArrayList<String>();
		
		List<String> list = new ArrayList<>();
		for (Object o : raw)
		{
			if (o != null) list.add(o.toString());
		}
		
		return list;
	}
	
	@Override
	public List<Integer> getIntList(String path)
	{
		return getIntList(path, null);
	}
	
	@Override
	public List<Integer> getIntList(String path, List<Integer> def)
	{
		List<?> raw = getList(path);
		if (raw == null) return (def != null) ? def : new ArrayList<Integer>();
		
		List<Integer> list = new ArrayList<>();
		for (Object o : raw)
		{
			Integer i = Integer.parseInt(o.toString());
			if (i != null) list.add(i);
		}
		
		return list;
	}
	
	@Override
	public List<Double> getDoubleList(String path)
	{
		return getDoubleList(path, null);
	}
	
	@Override
	public List<Double> getDoubleList(String path, List<Double> def)
	{
		List<?> raw = getList(path);
		if (raw == null) return (def != null) ? def : new ArrayList<Double>();
		
		List<Double> list = new ArrayList<>();
		for (Object o : raw)
		{
			Double d = Double.parseDouble(o.toString());
			if (d != null) list.add(d);
		}
		
		return list;
	}
	
	@Override
	public List<Boolean> getBooleanList(String path)
	{
		return getBooleanList(path, null);
	}
	
	@Override
	public List<Boolean> getBooleanList(String path, List<Boolean> def)
	{
		List<?> raw = getList(path);
		if (raw == null) return (def != null) ? def : new ArrayList<Boolean>();
		
		List<Boolean> list = new ArrayList<>();
		for (Object o : raw)
		{
			Boolean b = Boolean.parseBoolean(o.toString());
			if (b != null) list.add(b);
		}
		
		return list;
	}
}