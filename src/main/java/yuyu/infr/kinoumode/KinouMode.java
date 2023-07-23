package yuyu.infr.kinoumode;

import java.io.Serializable;

import jp.co.slcs.swak.web.action.ActionScoped;

/**
 * 機能モード クラスです。<br />
 * 機能モードの具体的な使用方法は Redmine (wiki) の開発者ガイドを参照してください。
 */
@ActionScoped
public class KinouMode implements Serializable {

    private static final long serialVersionUID = 2620081759019742515L;

    private static final String KINOUMODE_DEFAULT = "default";

    private String kinouMode =  KINOUMODE_DEFAULT;

    public void setKinouMode(String pKinouMode){
        kinouMode = pKinouMode;
    }

    public String getKinouMode(){
        return kinouMode;
    }

    @Override
    public String toString() {
        return "KinouMode(" + kinouMode + ")";
    }
}
