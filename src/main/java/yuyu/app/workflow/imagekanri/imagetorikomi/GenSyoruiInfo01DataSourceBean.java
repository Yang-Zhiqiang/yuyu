package yuyu.app.workflow.imagekanri.imagetorikomi;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * イメージ取込 - syoruiInfo01 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSyoruiInfo01DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsyoruinm;

    public String getDispsyoruinm() {
        return dispsyoruinm;
    }

    public void setDispsyoruinm(String pDispsyoruinm) {
        dispsyoruinm = pDispsyoruinm;
    }


    private String syoruittykymdtime;

    public String getSyoruittykymdtime() {
        return syoruittykymdtime;
    }

    public void setSyoruittykymdtime(String pSyoruittykymdtime) {
        syoruittykymdtime = pSyoruittykymdtime;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String userNm;

    public String getUserNm() {
        return userNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUserNm(String pUserNm) {
        userNm = pUserNm;
    }


    private String hyoujilink;

    public String getHyoujilink() {
        return hyoujilink;
    }

    public void setHyoujilink(String pHyoujilink) {
        hyoujilink = pHyoujilink;
    }


    private String torikomiLink;

    public String getTorikomiLink() {
        return torikomiLink;
    }

    public void setTorikomiLink(String pTorikomiLink) {
        torikomiLink = pTorikomiLink;
    }

}
