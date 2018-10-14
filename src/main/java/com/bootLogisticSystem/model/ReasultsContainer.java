package com.bootLogisticSystem.model;

import java.util.List;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.model.raportTemplates.OneValueReport;

public class ReasultsContainer{
	
	public Class<?> dataClass;
	private Object data;
	
    public <V> V get(Class<V> typeClass) {
        if(dataClass.equals(typeClass)) {
            return typeClass.cast(data);
        }
        return null;
    }
    
    public <V> V set(V obj, Class<V> typeClass) {
        if(dataClass.equals(typeClass)) {
            V toreturn = typeClass.cast(data);
            data = obj;
            return toreturn;
        }
        return null;
    }

	public void set(OneValueReport report, Class<?> typeClass) {
		set(report, typeClass);		
	}

	public void set(List<Request> reportList, Class<?> typeClass) {
		set(reportList, typeClass);			
	}
}
