package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_AksrendouzumiSkKykInfo;
import yuyu.def.db.mapping.GenJT_AksrendouzumiSkKykInfo;
import yuyu.def.db.meta.GenQJT_AksrendouzumiSkKykInfo;
import yuyu.def.db.meta.QJT_AksrendouzumiSkKykInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＡＫＳ連動済請求契約情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_AksrendouzumiSkKykInfo}</td><td colspan="3">ＡＫＳ連動済請求契約情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyubetu</td><td>請求種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuuSyubetu C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>shrkekkakbn</td><td>支払結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrKekkaKbn C_ShrKekkaKbn}</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sibouymd</td><td>死亡日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>geninkbn</td><td>原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GeninKbn C_GeninKbn}</td></tr>
 *  <tr><td>syoruiimagerendousuu</td><td>書類イメージ連動数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ankenimgjygntyoukahyj</td><td>案件イメージ上限数超過表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tiffhenkankekkakbn</td><td>ＴＩＦＦ変換結果区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_AksrendouzumiSkKykInfo
 * @see     GenJT_AksrendouzumiSkKykInfo
 * @see     QJT_AksrendouzumiSkKykInfo
 * @see     GenQJT_AksrendouzumiSkKykInfo
 */
public class PKJT_AksrendouzumiSkKykInfo extends AbstractExDBPrimaryKey<JT_AksrendouzumiSkKykInfo, PKJT_AksrendouzumiSkKykInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_AksrendouzumiSkKykInfo() {
    }

    public PKJT_AksrendouzumiSkKykInfo(String pSkno, String pSyono) {
        skno = pSkno;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<JT_AksrendouzumiSkKykInfo> getEntityClass() {
        return JT_AksrendouzumiSkKykInfo.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}