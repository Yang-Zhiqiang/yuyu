package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.io.Serializable;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 申込状況照会 - kouteiJyoukyouBaseInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKouteiJyoukyouBaseInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriTime;

    public String getSyoriTime() {
        return syoriTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriTime(String pSyoriTime) {
        syoriTime = pSyoriTime;
    }


    private String vprghsdisptasknm;

    public String getVprghsdisptasknm() {
        return vprghsdisptasknm;
    }

    public void setVprghsdisptasknm(String pVprghsdisptasknm) {
        vprghsdisptasknm = pVprghsdisptasknm;
    }


    private C_SyorikekkaKbn vprghsdispsyorikekkakbn;

    public C_SyorikekkaKbn getVprghsdispsyorikekkakbn() {
        return vprghsdispsyorikekkakbn;
    }

    public void setVprghsdispsyorikekkakbn(C_SyorikekkaKbn pVprghsdispsyorikekkakbn) {
        vprghsdispsyorikekkakbn = pVprghsdispsyorikekkakbn;
    }


    private String vprghsdispsousasyanm;

    public String getVprghsdispsousasyanm() {
        return vprghsdispsousasyanm;
    }

    public void setVprghsdispsousasyanm(String pVprghsdispsousasyanm) {
        vprghsdispsousasyanm = pVprghsdispsousasyanm;
    }


    private String vprghsdispcomment;

    public String getVprghsdispcomment() {
        return vprghsdispcomment;
    }

    public void setVprghsdispcomment(String pVprghsdispcomment) {
        vprghsdispcomment = pVprghsdispcomment;
    }

}
