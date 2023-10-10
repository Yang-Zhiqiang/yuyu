package yuyu.app.hozen.khozen.khnaiyoukakunin;

import java.io.Serializable;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.classification.C_HtysyoruiumuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 契約保全内容確認 - ●書類情報一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSyoruiInfoListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoruittykymdtime;

    public String getSyoruittykymdtime() {
        return syoruittykymdtime;
    }

    public void setSyoruittykymdtime(String pSyoruittykymdtime) {
        syoruittykymdtime = pSyoruittykymdtime;
    }


    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String syoruinm;

    public String getSyoruinm() {
        return syoruinm;
    }

    @Trim("both")
    public void setSyoruinm(String pSyoruinm) {
        syoruinm = pSyoruinm;
    }


    private C_HtysyoruiumuKbn htysyoruiumukbn;

    public C_HtysyoruiumuKbn getHtysyoruiumukbn() {
        return htysyoruiumukbn;
    }

    public void setHtysyoruiumukbn(C_HtysyoruiumuKbn pHtysyoruiumukbn) {
        htysyoruiumukbn = pHtysyoruiumukbn;
    }


    private String hyoujilink;

    public String getHyoujilink() {
        return hyoujilink;
    }

    public void setHyoujilink(String pHyoujilink) {
        hyoujilink = pHyoujilink;
    }


    private String hyoujilinkflg;

    public String getHyoujilinkflg() {
        return hyoujilinkflg;
    }

    public void setHyoujilinkflg(String pHyoujilinkflg) {
        hyoujilinkflg = pHyoujilinkflg;
    }

}
