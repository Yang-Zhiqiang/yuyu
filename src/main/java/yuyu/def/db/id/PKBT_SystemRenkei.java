package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_SystemRenkei;
import yuyu.def.db.mapping.GenBT_SystemRenkei;
import yuyu.def.db.meta.GenQBT_SystemRenkei;
import yuyu.def.db.meta.QBT_SystemRenkei;

/**
 * システム間連携制御テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SystemRenkei}</td><td colspan="3">システム間連携制御テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getInterfaceid interfaceid}</td><td>インターフェースＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorihousiki</td><td>処理方式</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn C_SystemRenkeiSyoriHousikiKbn}</td></tr>
 *  <tr><td>henkanhoukou</td><td>変換方向</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn C_SystemRenkeiHenkanHoukouKbn}</td></tr>
 *  <tr><td>henkanmaelayoutid</td><td>変換前レイアウトＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkanmaelayoutname</td><td>変換前レイアウト名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkangolayoutid</td><td>変換後レイアウトＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkangolayoutname</td><td>変換後レイアウト名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renkeifiledirectory</td><td>連携ファイル格納ディレクトリ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renkeifilenm</td><td>連携ファイル名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renkeifiletype</td><td>連携ファイル種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn C_SystemRenkeiFileSyubetuKbn}</td></tr>
 * </table>
 * @see     BT_SystemRenkei
 * @see     GenBT_SystemRenkei
 * @see     QBT_SystemRenkei
 * @see     GenQBT_SystemRenkei
 */
public class PKBT_SystemRenkei extends AbstractExDBPrimaryKey<BT_SystemRenkei, PKBT_SystemRenkei> {

    private static final long serialVersionUID = 1L;

    public PKBT_SystemRenkei() {
    }

    public PKBT_SystemRenkei(String pInterfaceid) {
        interfaceid = pInterfaceid;
    }

    @Transient
    @Override
    public Class<BT_SystemRenkei> getEntityClass() {
        return BT_SystemRenkei.class;
    }

    private String interfaceid;

    public String getInterfaceid() {
        return interfaceid;
    }

    public void setInterfaceid(String pInterfaceid) {
        interfaceid = pInterfaceid;
    }

}