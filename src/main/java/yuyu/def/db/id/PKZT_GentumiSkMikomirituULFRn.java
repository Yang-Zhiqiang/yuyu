package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.mapping.GenZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.meta.GenQZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.meta.QZT_GentumiSkMikomirituULFRn;

/**
 * 限積用失効見込率算出用ＵＬＦテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GentumiSkMikomirituULFRn}</td><td colspan="3">限積用失効見込率算出用ＵＬＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnraysystemhyj</td><td>（連携用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyoumetujiyuu</td><td>（連携用）（契約保全）消滅事由</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsymtymd</td><td>（連携用）消滅年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_GentumiSkMikomirituULFRn
 * @see     GenZT_GentumiSkMikomirituULFRn
 * @see     QZT_GentumiSkMikomirituULFRn
 * @see     GenQZT_GentumiSkMikomirituULFRn
 */
public class PKZT_GentumiSkMikomirituULFRn extends AbstractExDBPrimaryKey<ZT_GentumiSkMikomirituULFRn, PKZT_GentumiSkMikomirituULFRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_GentumiSkMikomirituULFRn() {
    }

    public PKZT_GentumiSkMikomirituULFRn(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    @Transient
    @Override
    public Class<ZT_GentumiSkMikomirituULFRn> getEntityClass() {
        return ZT_GentumiSkMikomirituULFRn.class;
    }

    private String zrndatakanrino;

    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

}