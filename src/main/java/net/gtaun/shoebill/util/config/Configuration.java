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

import java.util.List;

/**
 * 
 * 
 * @author MK124
 */
public interface Configuration
{
	public static final class ConfigurationPair
	{
		private String path;
		private Object value;
		
		public ConfigurationPair(String path, Object value)
		{
			this.path = path;
			this.value = value;
		}
		
		public String getPath()
		{
			return path;
		}
		
		public Object getValue()
		{
			return value;
		}
	}
	
	
	boolean contains(String path);
	
	Object get(String path);
	void set(String path, Object value);
	
	Configuration getSection(String path);
	
	void setDefault(String path, Object value);	
	Object getDefault(String path);
	
	String getString(String path);
	String getString(String path, String def);
	void setString(String path, Object value);
	boolean isString(String path);
	
	int getInt(String path);
	int getInt(String path, int def);
	void setInt(String path, int value);
	boolean isInt(String path);
	
	long getLong(String path);
	long getLong(String path, long def);
	void setLong(String path, long value);
	boolean isLong(String path);
	
	float getFloat(String path);
	float getFloat(String path, float def);
	void setFloat(String path, float value);
	boolean isFloat(String path);
	
	double getDouble(String path);
	double getDouble(String path, double def);
	void setDouble(String path, double value);
	boolean isDouble(String path);
	
	boolean getBoolean(String path);
	boolean getBoolean(String path, boolean def);
	void setBoolean(String path, boolean value);
	boolean isBoolean(String path);
	
	List<?> getList(String path);
	List<?> getList(String path, List<?> def);
	void setList(String path, List<?> value);
	boolean isList(String path);

	List<String> getStringList(String path);
	List<String> getStringList(String path, List<String> def);

	List<Integer> getIntList(String path);
	List<Integer> getIntList(String path, List<Integer> def);

	List<Float> getFloatList(String path);
	List<Float> getFloatList(String path, List<Float> def);

	List<Double> getDoubleList(String path);
	List<Double> getDoubleList(String path, List<Double> def);
	
	List<Boolean> getBooleanList(String path);
	List<Boolean> getBooleanList(String path, List<Boolean> def);
}
