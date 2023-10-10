package yuyu.app.direct.dssyoukai.dssousarirekisyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;

/**
 * 操作履歴照会 - ●操作履歴詳細情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSousarirekisyousaiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_DsSyoriNaiyouKbn syorinaiyoukbn;

    public C_DsSyoriNaiyouKbn getSyorinaiyoukbn() {
        return syorinaiyoukbn;
    }

    public void setSyorinaiyoukbn(C_DsSyoriNaiyouKbn pSyorinaiyoukbn) {
        syorinaiyoukbn = pSyorinaiyoukbn;
    }


    private BizDate syoriendymd;

    public BizDate getSyoriendymd() {
        return syoriendymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriendymd(BizDate pSyoriendymd) {
        syoriendymd = pSyoriendymd;
    }


    private String syoriendtime;

    public String getSyoriendtime() {
        return syoriendtime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriendtime(String pSyoriendtime) {
        syoriendtime = pSyoriendtime;
    }


    private String syorisyousai;

    public String getSyorisyousai() {
        return syorisyousai;
    }

    public void setSyorisyousai(String pSyorisyousai) {
        syorisyousai = pSyorisyousai;
    }

}
