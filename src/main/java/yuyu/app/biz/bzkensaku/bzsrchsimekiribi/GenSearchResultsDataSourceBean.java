package yuyu.app.biz.bzkensaku.bzsrchsimekiribi;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

/**
 * 締切日検索 - searchResults の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultsDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDateYM dispbosyuuym;

    public BizDateYM getDispbosyuuym() {
        return dispbosyuuym;
    }

    public void setDispbosyuuym(BizDateYM pDispbosyuuym) {
        dispbosyuuym = pDispbosyuuym;
    }


    private BizDate dispmossimefromymd;

    public BizDate getDispmossimefromymd() {
        return dispmossimefromymd;
    }

    public void setDispmossimefromymd(BizDate pDispmossimefromymd) {
        dispmossimefromymd = pDispmossimefromymd;
    }


    private BizDate dispmossimetoymd;

    public BizDate getDispmossimetoymd() {
        return dispmossimetoymd;
    }

    public void setDispmossimetoymd(BizDate pDispmossimetoymd) {
        dispmossimetoymd = pDispmossimetoymd;
    }


    private BizDate dispmosnrksimefromymd;

    public BizDate getDispmosnrksimefromymd() {
        return dispmosnrksimefromymd;
    }

    public void setDispmosnrksimefromymd(BizDate pDispmosnrksimefromymd) {
        dispmosnrksimefromymd = pDispmosnrksimefromymd;
    }


    private BizDate dispmosnrksimetoymd;

    public BizDate getDispmosnrksimetoymd() {
        return dispmosnrksimetoymd;
    }

    public void setDispmosnrksimetoymd(BizDate pDispmosnrksimetoymd) {
        dispmosnrksimetoymd = pDispmosnrksimetoymd;
    }


    private BizDate dispnrksimefromymd;

    public BizDate getDispnrksimefromymd() {
        return dispnrksimefromymd;
    }

    public void setDispnrksimefromymd(BizDate pDispnrksimefromymd) {
        dispnrksimefromymd = pDispnrksimefromymd;
    }


    private BizDate dispnrksimetoymd;

    public BizDate getDispnrksimetoymd() {
        return dispnrksimetoymd;
    }

    public void setDispnrksimetoymd(BizDate pDispnrksimetoymd) {
        dispnrksimetoymd = pDispnrksimetoymd;
    }


    private BizDate dispsyrisimefromymd;

    public BizDate getDispsyrisimefromymd() {
        return dispsyrisimefromymd;
    }

    public void setDispsyrisimefromymd(BizDate pDispsyrisimefromymd) {
        dispsyrisimefromymd = pDispsyrisimefromymd;
    }


    private BizDate dispsyrisimetoymd;

    public BizDate getDispsyrisimetoymd() {
        return dispsyrisimetoymd;
    }

    public void setDispsyrisimetoymd(BizDate pDispsyrisimetoymd) {
        dispsyrisimetoymd = pDispsyrisimetoymd;
    }

}
