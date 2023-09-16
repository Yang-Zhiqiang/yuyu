package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WT_ImageArriveNotice;
import yuyu.def.db.mapping.GenWT_ImageArriveNotice;
import yuyu.def.db.meta.GenQWT_ImageArriveNotice;
import yuyu.def.db.meta.QWT_ImageArriveNotice;

/**
 * 到着予定通知情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_ImageArriveNotice}</td><td colspan="3">到着予定通知情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getArriveKey arriveKey}</td><td>到着キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>torikomiSyoruiCd</td><td>取込書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKey</td><td>業務キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>flowId</td><td>フローＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_ImageArriveNotice
 * @see     GenWT_ImageArriveNotice
 * @see     QWT_ImageArriveNotice
 * @see     GenQWT_ImageArriveNotice
 */
public class PKWT_ImageArriveNotice extends AbstractExDBPrimaryKey<WT_ImageArriveNotice, PKWT_ImageArriveNotice> {

    private static final long serialVersionUID = 1L;

    public PKWT_ImageArriveNotice() {
    }

    public PKWT_ImageArriveNotice(String pArriveKey) {
        arriveKey = pArriveKey;
    }

    @Transient
    @Override
    public Class<WT_ImageArriveNotice> getEntityClass() {
        return WT_ImageArriveNotice.class;
    }

    private String arriveKey;

    public String getArriveKey() {
        return arriveKey;
    }

    public void setArriveKey(String pArriveKey) {
        arriveKey = pArriveKey;
    }

}