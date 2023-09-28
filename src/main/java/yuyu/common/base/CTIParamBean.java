package yuyu.common.base;

import java.io.Serializable;

import com.google.inject.servlet.SessionScoped;


@SessionScoped
public class CTIParamBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syono;

    public String getSyono(){
        return syono;
    }

    public void setSyono(String syono){
        this.syono = syono;
    }

}
