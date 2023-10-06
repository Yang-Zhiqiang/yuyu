package yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 新契約不備解消 - itiranInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenItiranInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @InvalidCharacter
    @MaxLength(max=20)
    @MultiByteStrings
    private String jimutetuzukinm;

    public String getJimutetuzukinm() {
        return jimutetuzukinm;
    }

    @DataConvert("toMultiByte")
    public void setJimutetuzukinm(String pJimutetuzukinm) {
        jimutetuzukinm = pJimutetuzukinm;
    }


    private BizDate jimustartymd;

    public BizDate getJimustartymd() {
        return jimustartymd;
    }

    public void setJimustartymd(BizDate pJimustartymd) {
        jimustartymd = pJimustartymd;
    }


    private String nyuuryokuLink;

    public String getNyuuryokuLink() {
        return nyuuryokuLink;
    }

    public void setNyuuryokuLink(String pNyuuryokuLink) {
        nyuuryokuLink = pNyuuryokuLink;
    }

}
