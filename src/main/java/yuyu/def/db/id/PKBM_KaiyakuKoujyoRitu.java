package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.BM_KaiyakuKoujyoRitu;
import yuyu.def.db.mapping.GenBM_KaiyakuKoujyoRitu;
import yuyu.def.db.meta.GenQBM_KaiyakuKoujyoRitu;
import yuyu.def.db.meta.QBM_KaiyakuKoujyoRitu;

/**
 * 解約控除率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KaiyakuKoujyoRitu}</td><td colspan="3">解約控除率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKaiyakukjtkybr1 kaiyakukjtkybr1}</td><td>解約控除適用分類１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKaiyakukjtkybr2 kaiyakukjtkybr2}</td><td>解約控除適用分類２</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKeikanensuu keikanensuu}</td><td>経過年数</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaiyakukoujyoritu</td><td>解約控除率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_KaiyakuKoujyoRitu
 * @see     GenBM_KaiyakuKoujyoRitu
 * @see     QBM_KaiyakuKoujyoRitu
 * @see     GenQBM_KaiyakuKoujyoRitu
 */
public class PKBM_KaiyakuKoujyoRitu extends AbstractExDBPrimaryKey<BM_KaiyakuKoujyoRitu, PKBM_KaiyakuKoujyoRitu> {

    private static final long serialVersionUID = 1L;

    public PKBM_KaiyakuKoujyoRitu() {
    }

    public PKBM_KaiyakuKoujyoRitu(
        String pSyouhncd,
        String pRyouritusdno,
        String pKaiyakukjtkybr1,
        String pKaiyakukjtkybr2,
        Integer pKeikanensuu
    ) {
        syouhncd = pSyouhncd;
        ryouritusdno = pRyouritusdno;
        kaiyakukjtkybr1 = pKaiyakukjtkybr1;
        kaiyakukjtkybr2 = pKaiyakukjtkybr2;
        keikanensuu = pKeikanensuu;
    }

    @Transient
    @Override
    public Class<BM_KaiyakuKoujyoRitu> getEntityClass() {
        return BM_KaiyakuKoujyoRitu.class;
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
    private String kaiyakukjtkybr1;

    public String getKaiyakukjtkybr1() {
        return kaiyakukjtkybr1;
    }

    public void setKaiyakukjtkybr1(String pKaiyakukjtkybr1) {
        kaiyakukjtkybr1 = pKaiyakukjtkybr1;
    }
    private String kaiyakukjtkybr2;

    public String getKaiyakukjtkybr2() {
        return kaiyakukjtkybr2;
    }

    public void setKaiyakukjtkybr2(String pKaiyakukjtkybr2) {
        kaiyakukjtkybr2 = pKaiyakukjtkybr2;
    }
    private Integer keikanensuu;

    public Integer getKeikanensuu() {
        return keikanensuu;
    }

    public void setKeikanensuu(Integer pKeikanensuu) {
        keikanensuu = pKeikanensuu;
    }

}