package com.kgm.kLibAmazon;

import java.io.File;
import org.w3c.dom.*;

/**
 * Created by goga on 7/18/14.
 */
public class kDbPricer
{
    File db_file;

    public kDbPricer()
    {

    }

    public kDbPricer(String path)
    {
        open(path);
    }

    public void close()
    {

    }

    public boolean open(String path)
    {
        return true;
    }

}
