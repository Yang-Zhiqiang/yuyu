package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HT_GrossNyknMeisai;
import yuyu.def.db.mapping.GenHT_GrossNyknMeisai;
import yuyu.def.db.meta.GenQHT_GrossNyknMeisai;
import yuyu.def.db.meta.QHT_GrossNyknMeisai;

/**
 * グロス入金明細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_GrossNyknMeisai}</td><td colspan="3">グロス入金明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMeisairenno meisairenno}</td><td>明細連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nykmosno</td><td>入金用申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsgaku</td><td>領収金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dengk</td><td>伝票金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_GrossNyknMeisai
 * @see     GenHT_GrossNyknMeisai
 * @see     QHT_GrossNyknMeisai
 * @see     GenQHT_GrossNyknMeisai
 */
public class PKHT_GrossNyknMeisai extends AbstractExDBPrimaryKey<HT_GrossNyknMeisai, PKHT_GrossNyknMeisai> {

    private static final long serialVersionUID = 1L;

    public PKHT_GrossNyknMeisai() {
    }

    public PKHT_GrossNyknMeisai(
        BizDate pRyosyuymd,
        String pOyadrtencd,
        Integer pRenno,
        Integer pMeisairenno
    ) {
        ryosyuymd = pRyosyuymd;
        oyadrtencd = pOyadrtencd;
        renno = pRenno;
        meisairenno = pMeisairenno;
    }

    @Transient
    @Override
    public Class<HT_GrossNyknMeisai> getEntityClass() {
        return HT_GrossNyknMeisai.class;
    }

    private BizDate ryosyuymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }
    private String oyadrtencd;

    public String getOyadrtencd() {
        return oyadrtencd;
    }

    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }
    private Integer meisairenno;

    public Integer getMeisairenno() {
        return meisairenno;
    }

    public void setMeisairenno(Integer pMeisairenno) {
        meisairenno = pMeisairenno;
    }

}