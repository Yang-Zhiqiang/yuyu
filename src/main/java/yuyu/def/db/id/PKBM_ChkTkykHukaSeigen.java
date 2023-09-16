package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkTkykHukaSeigen;
import yuyu.def.db.mapping.GenBM_ChkTkykHukaSeigen;
import yuyu.def.db.meta.GenQBM_ChkTkykHukaSeigen;
import yuyu.def.db.meta.QBM_ChkTkykHukaSeigen;

/**
 * 特約付加制限チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkTkykHukaSeigen}</td><td colspan="3">特約付加制限チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhncd syusyouhncd}</td><td>主契約商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSntkhoukbnfrom sntkhoukbnfrom}</td><td>選択方法区分自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSntkhoukbnto sntkhoukbnto}</td><td>選択方法区分至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTksyouhncd tksyouhncd}</td><td>特約商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_ChkTkykHukaSeigen
 * @see     GenBM_ChkTkykHukaSeigen
 * @see     QBM_ChkTkykHukaSeigen
 * @see     GenQBM_ChkTkykHukaSeigen
 */
public class PKBM_ChkTkykHukaSeigen extends AbstractExDBPrimaryKey<BM_ChkTkykHukaSeigen, PKBM_ChkTkykHukaSeigen> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkTkykHukaSeigen() {
    }

    public PKBM_ChkTkykHukaSeigen(
        String pSyusyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        Integer pSntkhoukbnfrom,
        Integer pSntkhoukbnto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        String pTksyouhncd
    ) {
        syusyouhncd = pSyusyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        sntkhoukbnfrom = pSntkhoukbnfrom;
        sntkhoukbnto = pSntkhoukbnto;
        hhknfromnen = pHhknfromnen;
        hhkntonen = pHhkntonen;
        tksyouhncd = pTksyouhncd;
    }

    @Transient
    @Override
    public Class<BM_ChkTkykHukaSeigen> getEntityClass() {
        return BM_ChkTkykHukaSeigen.class;
    }

    private String syusyouhncd;

    public String getSyusyouhncd() {
        return syusyouhncd;
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        syusyouhncd = pSyusyouhncd;
    }
    private Integer syusyouhnsdnofrom;

    public Integer getSyusyouhnsdnofrom() {
        return syusyouhnsdnofrom;
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
    }
    private Integer syusyouhnsdnoto;

    public Integer getSyusyouhnsdnoto() {
        return syusyouhnsdnoto;
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        syusyouhnsdnoto = pSyusyouhnsdnoto;
    }
    private Integer sntkhoukbnfrom;

    public Integer getSntkhoukbnfrom() {
        return sntkhoukbnfrom;
    }

    public void setSntkhoukbnfrom(Integer pSntkhoukbnfrom) {
        sntkhoukbnfrom = pSntkhoukbnfrom;
    }
    private Integer sntkhoukbnto;

    public Integer getSntkhoukbnto() {
        return sntkhoukbnto;
    }

    public void setSntkhoukbnto(Integer pSntkhoukbnto) {
        sntkhoukbnto = pSntkhoukbnto;
    }
    private BizNumber hhknfromnen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHhknfromnen() {
        return hhknfromnen;
    }

    public void setHhknfromnen(BizNumber pHhknfromnen) {
        hhknfromnen = pHhknfromnen;
    }
    private BizNumber hhkntonen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHhkntonen() {
        return hhkntonen;
    }

    public void setHhkntonen(BizNumber pHhkntonen) {
        hhkntonen = pHhkntonen;
    }
    private String tksyouhncd;

    public String getTksyouhncd() {
        return tksyouhncd;
    }

    public void setTksyouhncd(String pTksyouhncd) {
        tksyouhncd = pTksyouhncd;
    }

}