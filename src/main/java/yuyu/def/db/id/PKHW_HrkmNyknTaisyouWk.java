package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.db.mapping.GenHW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.GenQHW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.QHW_HrkmNyknTaisyouWk;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 振込入金対象ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_HrkmNyknTaisyouWk}</td><td colspan="3">振込入金対象ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ryosyuymd</td><td>領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkmirninnm</td><td>振込依頼人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsgaku</td><td>領収金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rstuukasyu</td><td>領収通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>rsgakuen</td><td>領収金額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hrkmtsry</td><td>振込手数料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nyksyoriymd</td><td>入金処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkmnykndatarenmotoKbn</td><td>振込入金データ連携元区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkmnykndatarenmotoKbn C_HrkmnykndatarenmotoKbn}</td></tr>
 *  <tr><td>nyktyhyoutkbn</td><td>入金帳票出力先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyktyhyoutKbn C_NyktyhyoutKbn}</td></tr>
 *  <tr><td>syorizumiflg</td><td>処理済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syorizumiflg C_Syorizumiflg}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_HrkmNyknTaisyouWk
 * @see     GenHW_HrkmNyknTaisyouWk
 * @see     QHW_HrkmNyknTaisyouWk
 * @see     GenQHW_HrkmNyknTaisyouWk
 */
public class PKHW_HrkmNyknTaisyouWk extends AbstractExDBPrimaryKey<HW_HrkmNyknTaisyouWk, PKHW_HrkmNyknTaisyouWk> {

    private static final long serialVersionUID = 1L;

    public PKHW_HrkmNyknTaisyouWk() {
    }

    public PKHW_HrkmNyknTaisyouWk(
        BizDate pSyoriYmd,
        String pMosno,
        Integer pRenno
    ) {
        syoriYmd = pSyoriYmd;
        mosno = pMosno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HW_HrkmNyknTaisyouWk> getEntityClass() {
        return HW_HrkmNyknTaisyouWk.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}