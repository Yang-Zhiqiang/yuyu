package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_HaitaSeigyo;
import yuyu.def.db.mapping.GenAT_HaitaSeigyo;
import yuyu.def.db.meta.GenQAT_HaitaSeigyo;
import yuyu.def.db.meta.QAT_HaitaSeigyo;

/**
 * 排他制御テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_HaitaSeigyo}</td><td colspan="3">排他制御テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHaitaSyuruiCd haitaSyuruiCd}</td><td>排他種類コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHaitaKey haitaKey}</td><td>排他キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haitamotoKinouId</td><td>排他元機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haitaUserId</td><td>排他ユーザーＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haitaKaisiTime</td><td>排他開始時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haitaUniqueKey</td><td>排他ユニークキー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_HaitaSeigyo
 * @see     GenAT_HaitaSeigyo
 * @see     QAT_HaitaSeigyo
 * @see     GenQAT_HaitaSeigyo
 */
public class PKAT_HaitaSeigyo extends AbstractExDBPrimaryKey<AT_HaitaSeigyo, PKAT_HaitaSeigyo> {

    private static final long serialVersionUID = 1L;

    public PKAT_HaitaSeigyo() {
    }

    public PKAT_HaitaSeigyo(String pHaitaSyuruiCd, String pHaitaKey) {
        haitaSyuruiCd = pHaitaSyuruiCd;
        haitaKey = pHaitaKey;
    }

    @Transient
    @Override
    public Class<AT_HaitaSeigyo> getEntityClass() {
        return AT_HaitaSeigyo.class;
    }

    private String haitaSyuruiCd;

    public String getHaitaSyuruiCd() {
        return haitaSyuruiCd;
    }

    public void setHaitaSyuruiCd(String pHaitaSyuruiCd) {
        haitaSyuruiCd = pHaitaSyuruiCd;
    }
    private String haitaKey;

    public String getHaitaKey() {
        return haitaKey;
    }

    public void setHaitaKey(String pHaitaKey) {
        haitaKey = pHaitaKey;
    }

}