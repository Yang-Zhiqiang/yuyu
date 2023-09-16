package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.mapping.GenWT_KouteiRireki;
import yuyu.def.db.meta.GenQWT_KouteiRireki;
import yuyu.def.db.meta.QWT_KouteiRireki;

/**
 * 工程履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_KouteiRireki}</td><td colspan="3">工程履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTokenId tokenId}</td><td>トークンＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKey</td><td>業務キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRirekiKbn rirekiKbn}</td><td>履歴区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_RirekiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriTime syoriTime}</td><td>処理時間</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>flowId</td><td>フローＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nodeId</td><td>ノードＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nodeNm</td><td>ノード名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userId</td><td>ユーザーＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>iwfSyoriKbn</td><td>IWF処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IwfSyoriKbn C_IwfSyoriKbn}</td></tr>
 *  <tr><td>rrkMsg</td><td>履歴メッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extInfo</td><td>付加情報</td><td>&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 * </table>
 * @see     WT_KouteiRireki
 * @see     GenWT_KouteiRireki
 * @see     QWT_KouteiRireki
 * @see     GenQWT_KouteiRireki
 */
public class PKWT_KouteiRireki extends AbstractExDBPrimaryKey<WT_KouteiRireki, PKWT_KouteiRireki> {

    private static final long serialVersionUID = 1L;

    public PKWT_KouteiRireki() {
    }

    public PKWT_KouteiRireki(
        String pTokenId,
        C_RirekiKbn pRirekiKbn,
        String pSyoriTime
    ) {
        tokenId = pTokenId;
        rirekiKbn = pRirekiKbn;
        syoriTime = pSyoriTime;
    }

    @Transient
    @Override
    public Class<WT_KouteiRireki> getEntityClass() {
        return WT_KouteiRireki.class;
    }

    private String tokenId;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String pTokenId) {
        tokenId = pTokenId;
    }
    private C_RirekiKbn rirekiKbn;

    @org.hibernate.annotations.Type(type="UserType_C_RirekiKbn")
    public C_RirekiKbn getRirekiKbn() {
        return rirekiKbn;
    }

    public void setRirekiKbn(C_RirekiKbn pRirekiKbn) {
        rirekiKbn = pRirekiKbn;
    }
    private String syoriTime;

    public String getSyoriTime() {
        return syoriTime;
    }

    public void setSyoriTime(String pSyoriTime) {
        syoriTime = pSyoriTime;
    }

}