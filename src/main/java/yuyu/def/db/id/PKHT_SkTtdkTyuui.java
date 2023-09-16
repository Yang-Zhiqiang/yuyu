package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.mapping.GenHT_SkTtdkTyuui;
import yuyu.def.db.meta.GenQHT_SkTtdkTyuui;
import yuyu.def.db.meta.QHT_SkTtdkTyuui;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約手続注意テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkTtdkTyuui}</td><td colspan="3">新契約手続注意テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkeittdkrenrakukbn skeittdkrenrakukbn}</td><td>新契約手続連絡区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SkeittdkrenrakuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>skeittdktyuuinaiyou</td><td>新契約手続注意内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkymd</td><td>登録日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkTtdkTyuui
 * @see     GenHT_SkTtdkTyuui
 * @see     QHT_SkTtdkTyuui
 * @see     GenQHT_SkTtdkTyuui
 */
public class PKHT_SkTtdkTyuui extends AbstractExDBPrimaryKey<HT_SkTtdkTyuui, PKHT_SkTtdkTyuui> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkTtdkTyuui() {
    }

    public PKHT_SkTtdkTyuui(
        String pMosno,
        C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn,
        Integer pDatarenno
    ) {
        mosno = pMosno;
        skeittdkrenrakukbn = pSkeittdkrenrakukbn;
        datarenno = pDatarenno;
    }

    @Transient
    @Override
    public Class<HT_SkTtdkTyuui> getEntityClass() {
        return HT_SkTtdkTyuui.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private C_SkeittdkrenrakuKbn skeittdkrenrakukbn;

    @org.hibernate.annotations.Type(type="UserType_C_SkeittdkrenrakuKbn")
    public C_SkeittdkrenrakuKbn getSkeittdkrenrakukbn() {
        return skeittdkrenrakukbn;
    }

    public void setSkeittdkrenrakukbn(C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn) {
        skeittdkrenrakukbn = pSkeittdkrenrakukbn;
    }
    private Integer datarenno;

    public Integer getDatarenno() {
        return datarenno;
    }

    public void setDatarenno(Integer pDatarenno) {
        datarenno = pDatarenno;
    }

}