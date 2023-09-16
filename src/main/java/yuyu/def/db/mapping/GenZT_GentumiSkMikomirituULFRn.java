package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.id.PKZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.meta.GenQZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.meta.QZT_GentumiSkMikomirituULFRn;

/**
 * 限積用失効見込率算出用ＵＬＦテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_GentumiSkMikomirituULFRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GentumiSkMikomirituULFRn}</td><td colspan="3">限積用失効見込率算出用ＵＬＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">{@link PKZT_GentumiSkMikomirituULFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyoumetujiyuu zrnkhsyoumetujiyuu}</td><td>（連携用）（契約保全）消滅事由</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtymd zrnsymtymd}</td><td>（連携用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_GentumiSkMikomirituULFRn
 * @see     PKZT_GentumiSkMikomirituULFRn
 * @see     QZT_GentumiSkMikomirituULFRn
 * @see     GenQZT_GentumiSkMikomirituULFRn
 */
@MappedSuperclass
@Table(name=GenZT_GentumiSkMikomirituULFRn.TABLE_NAME)
@IdClass(value=PKZT_GentumiSkMikomirituULFRn.class)
public abstract class GenZT_GentumiSkMikomirituULFRn extends AbstractExDBEntityForZDB<ZT_GentumiSkMikomirituULFRn, PKZT_GentumiSkMikomirituULFRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_GentumiSkMikomirituULFRn";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNKHSYOUMETUJIYUU       = "zrnkhsyoumetujiyuu";
    public static final String ZRNSYMTYMD               = "zrnsymtymd";

    private final PKZT_GentumiSkMikomirituULFRn primaryKey;

    public GenZT_GentumiSkMikomirituULFRn() {
        primaryKey = new PKZT_GentumiSkMikomirituULFRn();
    }

    public GenZT_GentumiSkMikomirituULFRn(String pZrndatakanrino) {
        primaryKey = new PKZT_GentumiSkMikomirituULFRn(pZrndatakanrino);
    }

    @Transient
    @Override
    public PKZT_GentumiSkMikomirituULFRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_GentumiSkMikomirituULFRn> getMetaClass() {
        return QZT_GentumiSkMikomirituULFRn.class;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_GentumiSkMikomirituULFRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    @Id
    @Column(name=GenZT_GentumiSkMikomirituULFRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return getPrimaryKey().getZrndatakanrino();
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        getPrimaryKey().setZrndatakanrino(pZrndatakanrino);
    }

    private String zrnkhsyoumetujiyuu;

    @Column(name=GenZT_GentumiSkMikomirituULFRn.ZRNKHSYOUMETUJIYUU)
    public String getZrnkhsyoumetujiyuu() {
        return zrnkhsyoumetujiyuu;
    }

    public void setZrnkhsyoumetujiyuu(String pZrnkhsyoumetujiyuu) {
        zrnkhsyoumetujiyuu = pZrnkhsyoumetujiyuu;
    }

    private String zrnsymtymd;

    @Column(name=GenZT_GentumiSkMikomirituULFRn.ZRNSYMTYMD)
    public String getZrnsymtymd() {
        return zrnsymtymd;
    }

    public void setZrnsymtymd(String pZrnsymtymd) {
        zrnsymtymd = pZrnsymtymd;
    }
}