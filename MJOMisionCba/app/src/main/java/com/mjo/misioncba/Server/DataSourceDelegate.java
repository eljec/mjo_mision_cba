package com.mjo.misioncba.Server;

/**
 * Created by jucastillo on 24/12/17.
 */

public interface DataSourceDelegate
{
    public void loadSuccess(Object result);

    public  void loadFail(Object error);
}
