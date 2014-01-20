package ua.np.services.printforms;

import java.util.List;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 25.11.13
 * Time: 15:38
 */
public class OutputResource {

    private List<String> contentType;

    public List<String> getContentType () {
        return contentType;
    }

    public void setContentType ( List<String> contentType ) {
        this.contentType = contentType;
    }
}
