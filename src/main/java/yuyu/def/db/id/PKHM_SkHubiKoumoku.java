package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.mapping.GenHM_SkHubiKoumoku;
import yuyu.def.db.meta.GenQHM_SkHubiKoumoku;
import yuyu.def.db.meta.QHM_SkHubiKoumoku;

/**
 * 新契約不備項目マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkHubiKoumoku}</td><td colspan="3">新契約不備項目マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkhubikoumokucd skhubikoumokucd}</td><td>新契約不備項目コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skhubikoumoku</td><td>新契約不備項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hyoujikahikbn</td><td>表示可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 * </table>
 * @see     HM_SkHubiKoumoku
 * @see     GenHM_SkHubiKoumoku
 * @see     QHM_SkHubiKoumoku
 * @see     GenQHM_SkHubiKoumoku
 */
public class PKHM_SkHubiKoumoku extends AbstractExDBPrimaryKey<HM_SkHubiKoumoku, PKHM_SkHubiKoumoku> {

    private static final long serialVersionUID = 1L;

    public PKHM_SkHubiKoumoku() {
    }

    public PKHM_SkHubiKoumoku(C_SyoruiCdKbn pSyoruiCd, String pSkhubikoumokucd) {
        syoruiCd = pSyoruiCd;
        skhubikoumokucd = pSkhubikoumokucd;
    }

    @Transient
    @Override
    public Class<HM_SkHubiKoumoku> getEntityClass() {
        return HM_SkHubiKoumoku.class;
    }

    private C_SyoruiCdKbn syoruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_SyoruiCdKbn")
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }
    private String skhubikoumokucd;

    public String getSkhubikoumokucd() {
        return skhubikoumokucd;
    }

    public void setSkhubikoumokucd(String pSkhubikoumokucd) {
        skhubikoumokucd = pSkhubikoumokucd;
    }

}