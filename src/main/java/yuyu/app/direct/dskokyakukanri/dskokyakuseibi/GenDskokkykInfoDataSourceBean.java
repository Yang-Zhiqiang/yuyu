package yuyu.app.direct.dskokyakukanri.dskokyakuseibi;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_MukouHyj;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 顧客整備 - ●ＤＳ顧客契約 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenDskokkykInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }


    private String syusyouhnnm;

    public String getSyusyouhnnm() {
        return syusyouhnnm;
    }

    public void setSyusyouhnnm(String pSyusyouhnnm) {
        syusyouhnnm = pSyusyouhnnm;
    }


    private BizDate dskykkanyuuymd;

    public BizDate getDskykkanyuuymd() {
        return dskykkanyuuymd;
    }

    public void setDskykkanyuuymd(BizDate pDskykkanyuuymd) {
        dskykkanyuuymd = pDskykkanyuuymd;
    }


    private BizDate dskykhenkouymd;

    public BizDate getDskykhenkouymd() {
        return dskykhenkouymd;
    }

    public void setDskykhenkouymd(BizDate pDskykhenkouymd) {
        dskykhenkouymd = pDskykhenkouymd;
    }


    private C_MukouHyj dskykmukouhyj;

    public C_MukouHyj getDskykmukouhyj() {
        return dskykmukouhyj;
    }

    public void setDskykmukouhyj(C_MukouHyj pDskykmukouhyj) {
        dskykmukouhyj = pDskykmukouhyj;
    }


    private BizDate dskykmukouymd;

    public BizDate getDskykmukouymd() {
        return dskykmukouymd;
    }

    public void setDskykmukouymd(BizDate pDskykmukouymd) {
        dskykmukouymd = pDskykmukouymd;
    }

}
