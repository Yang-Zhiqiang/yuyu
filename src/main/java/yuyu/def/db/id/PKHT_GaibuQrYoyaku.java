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
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_GaibuQrYoyaku;
import yuyu.def.db.mapping.GenHT_GaibuQrYoyaku;
import yuyu.def.db.meta.GenQHT_GaibuQrYoyaku;
import yuyu.def.db.meta.QHT_GaibuQrYoyaku;

/**
 * 外部用ＱＲ予約テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_GaibuQrYoyaku}</td><td colspan="3">外部用ＱＲ予約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">○</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>sakuseikensuu</td><td>作成件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>qrsakuseiymd</td><td>ＱＲ作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_GaibuQrYoyaku
 * @see     GenHT_GaibuQrYoyaku
 * @see     QHT_GaibuQrYoyaku
 * @see     GenQHT_GaibuQrYoyaku
 */
public class PKHT_GaibuQrYoyaku extends AbstractExDBPrimaryKey<HT_GaibuQrYoyaku, PKHT_GaibuQrYoyaku> {

    private static final long serialVersionUID = 1L;

    public PKHT_GaibuQrYoyaku() {
    }

    public PKHT_GaibuQrYoyaku(
        BizDate pSyoriYmd,
        C_SkeijimuKbn pSkeijimukbn,
        C_HknsyuruiNo pHknsyuruino
    ) {
        syoriYmd = pSyoriYmd;
        skeijimukbn = pSkeijimukbn;
        hknsyuruino = pHknsyuruino;
    }

    @Transient
    @Override
    public Class<HT_GaibuQrYoyaku> getEntityClass() {
        return HT_GaibuQrYoyaku.class;
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

}