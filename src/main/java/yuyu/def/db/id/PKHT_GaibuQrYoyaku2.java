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
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_GaibuQrYoyaku2;
import yuyu.def.db.mapping.GenHT_GaibuQrYoyaku2;
import yuyu.def.db.meta.GenQHT_GaibuQrYoyaku2;
import yuyu.def.db.meta.QHT_GaibuQrYoyaku2;

/**
 * 外部用ＱＲ予約テーブル２ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_GaibuQrYoyaku2}</td><td colspan="3">外部用ＱＲ予約テーブル２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">○</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosnosaibankbn mosnosaibankbn}</td><td>申込番号採番区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_MosnoSaibanKbn}</td></tr>
 *  <tr><td>mosnosaibansuu</td><td>申込番号採番数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sakuseikensuu</td><td>作成件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>qrsakuseiymd</td><td>ＱＲ作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_GaibuQrYoyaku2
 * @see     GenHT_GaibuQrYoyaku2
 * @see     QHT_GaibuQrYoyaku2
 * @see     GenQHT_GaibuQrYoyaku2
 */
public class PKHT_GaibuQrYoyaku2 extends AbstractExDBPrimaryKey<HT_GaibuQrYoyaku2, PKHT_GaibuQrYoyaku2> {

    private static final long serialVersionUID = 1L;

    public PKHT_GaibuQrYoyaku2() {
    }

    public PKHT_GaibuQrYoyaku2(
        BizDate pSyoriYmd,
        C_SkeijimuKbn pSkeijimukbn,
        C_HknsyuruiNo pHknsyuruino,
        C_MosnoSaibanKbn pMosnosaibankbn
    ) {
        syoriYmd = pSyoriYmd;
        skeijimukbn = pSkeijimukbn;
        hknsyuruino = pHknsyuruino;
        mosnosaibankbn = pMosnosaibankbn;
    }

    @Transient
    @Override
    public Class<HT_GaibuQrYoyaku2> getEntityClass() {
        return HT_GaibuQrYoyaku2.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private C_SkeijimuKbn skeijimukbn;

    @org.hibernate.annotations.Type(type="UserType_C_SkeijimuKbn")
    public C_SkeijimuKbn getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }
    private C_HknsyuruiNo hknsyuruino;

    @org.hibernate.annotations.Type(type="UserType_C_HknsyuruiNo")
    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        hknsyuruino = pHknsyuruino;
    }
    private C_MosnoSaibanKbn mosnosaibankbn;

    @org.hibernate.annotations.Type(type="UserType_C_MosnoSaibanKbn")
    public C_MosnoSaibanKbn getMosnosaibankbn() {
        return mosnosaibankbn;
    }

    public void setMosnosaibankbn(C_MosnoSaibanKbn pMosnosaibankbn) {
        mosnosaibankbn = pMosnosaibankbn;
    }

}