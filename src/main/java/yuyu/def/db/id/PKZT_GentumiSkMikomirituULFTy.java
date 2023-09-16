package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.mapping.GenZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.meta.GenQZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.meta.QZT_GentumiSkMikomirituULFTy;

/**
 * 限積用失効見込率算出用ＵＬＦテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GentumiSkMikomirituULFTy}</td><td colspan="3">限積用失効見込率算出用ＵＬＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyoumetujiyuu</td><td>（中継用）（契約保全）消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysymtymd</td><td>（中継用）消滅年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_GentumiSkMikomirituULFTy
 * @see     GenZT_GentumiSkMikomirituULFTy
 * @see     QZT_GentumiSkMikomirituULFTy
 * @see     GenQZT_GentumiSkMikomirituULFTy
 */
public class PKZT_GentumiSkMikomirituULFTy extends AbstractExDBPrimaryKey<ZT_GentumiSkMikomirituULFTy, PKZT_GentumiSkMikomirituULFTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_GentumiSkMikomirituULFTy() {
    }

    public PKZT_GentumiSkMikomirituULFTy(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    @Transient
    @Override
    public Class<ZT_GentumiSkMikomirituULFTy> getEntityClass() {
        return ZT_GentumiSkMikomirituULFTy.class;
    }

    private String ztydatakanrino;

    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

}