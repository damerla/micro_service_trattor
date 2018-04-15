package com.damerla.trattor.service;
/*
 * @author  Hari
 * @date  4/14/2018
 * @version 1.0.0
 */


import com.damerla.trattor.model.StatusType;

import java.util.function.Supplier;

public interface ICrudService {

    public <T> Boolean saveOrUpdate(T model);

    public  Boolean changeStatus(String entityId, String statusType);

}
