package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo2;
import yuyu.def.db.mapping.GenBM_IkkatuTekiyouNo2;
import yuyu.def.db.meta.GenQBM_IkkatuTekiyouNo2;
import yuyu.def.db.meta.QBM_IkkatuTekiyouNo2;

/**
 * 一括払適用番号マスタ２ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_IkkatuTekiyouNo2}</td><td colspan="3">一括払適用番号マスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIkttekiyoubr1 ikttekiyoubr1}</td><td>一括払適用分類１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIkttekiyoubr2 ikttekiyoubr2}</td><td>一括払適用分類２</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIkttekiyoubr3 ikttekiyoubr3}</td><td>一括払適用分類３</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ikttekiyouno</td><td>一括払適用番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BM_IkkatuTekiyouNo2
 * @see     GenBM_IkkatuTekiyouNo2
 * @see     QBM_IkkatuTekiyouNo2
 * @see     GenQBM_IkkatuTekiyouNo2
 */
public class PKBM_IkkatuTekiyouNo2 extends AbstractExDBPrimaryKey<BM_IkkatuTekiyouNo2, PKBM_IkkatuTekiyouNo2> {

    private static final long serialVersionUID = 1L;

    public PKBM_IkkatuTekiyouNo2() {
    }

    public PKBM_IkkatuTekiyouNo2(
        String pSyouhncd,
        String pRyouritusdno,
        BizNumber pYoteiriritu,
        String pIkttekiyoubr1,
        String pIkttekiyoubr2,
        String pIkttekiyoubr3
    ) {
        syouhncd = pSyouhncd;
        ryouritusdno = pRyouritusdno;
        yoteiriritu = pYoteiriritu;
        ikttekiyoubr1 = pIkttekiyoubr1;
        ikttekiyoubr2 = pIkttekiyoubr2;
        ikttekiyoubr3 = pIkttekiyoubr3;
    }

    @Transient
    @Override
    public Class<BM_IkkatuTekiyouNo2> getEntityClass() {
        return BM_IkkatuTekiyouNo2.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private String ryouritusdno;

    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }
    private BizNumber yoteiriritu;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }
    private String ikttekiyoubr1;

    public String getIkttekiyoubr1() {
        return ikttekiyoubr1;
    }

    public void setIkttekiyoubr1(String pIkttekiyoubr1) {
        ikttekiyoubr1 = pIkttekiyoubr1;
    }
    private String ikttekiyoubr2;

    public String getIkttekiyoubr2() {
        return ikttekiyoubr2;
    }

    public void setIkttekiyoubr2(String pIkttekiyoubr2) {
        ikttekiyoubr2 = pIkttekiyoubr2;
    }
    private String ikttekiyoubr3;

    public String getIkttekiyoubr3() {
        return ikttekiyoubr3;
    }

    public void setIkttekiyoubr3(String pIkttekiyoubr3) {
        ikttekiyoubr3 = pIkttekiyoubr3;
    }

}