package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.db.mapping.GenWT_TorikomiRelation;
import yuyu.def.db.meta.GenQWT_TorikomiRelation;
import yuyu.def.db.meta.QWT_TorikomiRelation;

/**
 * 取込関連テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_TorikomiRelation}</td><td colspan="3">取込関連テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIwfImageId iwfImageId}</td><td>IWFイメージＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getGyoumuKey gyoumuKey}</td><td>業務キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_TorikomiRelation
 * @see     GenWT_TorikomiRelation
 * @see     QWT_TorikomiRelation
 * @see     GenQWT_TorikomiRelation
 */
public class PKWT_TorikomiRelation extends AbstractExDBPrimaryKey<WT_TorikomiRelation, PKWT_TorikomiRelation> {

    private static final long serialVersionUID = 1L;

    public PKWT_TorikomiRelation() {
    }

    public PKWT_TorikomiRelation(String pGyoumuKey, String pIwfImageId) {
        gyoumuKey = pGyoumuKey;
        iwfImageId = pIwfImageId;
    }

    @Transient
    @Override
    public Class<WT_TorikomiRelation> getEntityClass() {
        return WT_TorikomiRelation.class;
    }

    private String gyoumuKey;

    public String getGyoumuKey() {
        return gyoumuKey;
    }

    public void setGyoumuKey(String pGyoumuKey) {
        gyoumuKey = pGyoumuKey;
    }
    private String iwfImageId;

    public String getIwfImageId() {
        return iwfImageId;
    }

    public void setIwfImageId(String pIwfImageId) {
        iwfImageId = pIwfImageId;
    }

}