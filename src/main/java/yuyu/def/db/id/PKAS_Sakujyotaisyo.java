package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AS_Sakujyotaisyo;
import yuyu.def.db.mapping.GenAS_Sakujyotaisyo;
import yuyu.def.db.meta.GenQAS_Sakujyotaisyo;
import yuyu.def.db.meta.QAS_Sakujyotaisyo;

/**
 * 削除対象基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_Sakujyotaisyo}</td><td colspan="3">削除対象基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSakujyoTableId sakujyoTableId}</td><td>削除対象テーブルＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sakujyoKbn</td><td>削除区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SakujyoKbn C_SakujyoKbn}</td></tr>
 *  <tr><td>sakujyoKey</td><td>削除キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sakujyoKeyKbn</td><td>削除キー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SakujyoKeyKbn C_SakujyoKeyKbn}</td></tr>
 *  <tr><td>hozonKikan</td><td>保存期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nengappiKbn</td><td>年月日区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NengappiKbn C_NengappiKbn}</td></tr>
 *  <tr><td>dataTaihiKbn</td><td>データ退避区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 * </table>
 * @see     AS_Sakujyotaisyo
 * @see     GenAS_Sakujyotaisyo
 * @see     QAS_Sakujyotaisyo
 * @see     GenQAS_Sakujyotaisyo
 */
public class PKAS_Sakujyotaisyo extends AbstractExDBPrimaryKey<AS_Sakujyotaisyo, PKAS_Sakujyotaisyo> {

    private static final long serialVersionUID = 1L;

    public PKAS_Sakujyotaisyo() {
    }

    public PKAS_Sakujyotaisyo(String pSakujyoTableId) {
        sakujyoTableId = pSakujyoTableId;
    }

    @Transient
    @Override
    public Class<AS_Sakujyotaisyo> getEntityClass() {
        return AS_Sakujyotaisyo.class;
    }

    private String sakujyoTableId;

    public String getSakujyoTableId() {
        return sakujyoTableId;
    }

    public void setSakujyoTableId(String pSakujyoTableId) {
        sakujyoTableId = pSakujyoTableId;
    }

}