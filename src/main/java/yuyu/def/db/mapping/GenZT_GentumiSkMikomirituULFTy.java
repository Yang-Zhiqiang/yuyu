package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.id.PKZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.meta.GenQZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.meta.QZT_GentumiSkMikomirituULFTy;

/**
 * 限積用失効見込率算出用ＵＬＦテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_GentumiSkMikomirituULFTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GentumiSkMikomirituULFTy}</td><td colspan="3">限積用失効見込率算出用ＵＬＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">{@link PKZT_GentumiSkMikomirituULFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyoumetujiyuu ztykhsyoumetujiyuu}</td><td>（中継用）（契約保全）消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysymtymd ztysymtymd}</td><td>（中継用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_GentumiSkMikomirituULFTy
 * @see     PKZT_GentumiSkMikomirituULFTy
 * @see     QZT_GentumiSkMikomirituULFTy
 * @see     GenQZT_GentumiSkMikomirituULFTy
 */
@MappedSuperclass
@Table(name=GenZT_GentumiSkMikomirituULFTy.TABLE_NAME)
@IdClass(value=PKZT_GentumiSkMikomirituULFTy.class)
public abstract class GenZT_GentumiSkMikomirituULFTy extends AbstractExDBEntity<ZT_GentumiSkMikomirituULFTy, PKZT_GentumiSkMikomirituULFTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_GentumiSkMikomirituULFTy";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYKHSYOUMETUJIYUU       = "ztykhsyoumetujiyuu";
    public static final String ZTYSYMTYMD               = "ztysymtymd";

    private final PKZT_GentumiSkMikomirituULFTy primaryKey;

    public GenZT_GentumiSkMikomirituULFTy() {
        primaryKey = new PKZT_GentumiSkMikomirituULFTy();
    }

    public GenZT_GentumiSkMikomirituULFTy(String pZtydatakanrino) {
        primaryKey = new PKZT_GentumiSkMikomirituULFTy(pZtydatakanrino);
    }

    @Transient
    @Override
    public PKZT_GentumiSkMikomirituULFTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_GentumiSkMikomirituULFTy> getMetaClass() {
        return QZT_GentumiSkMikomirituULFTy.class;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_GentumiSkMikomirituULFTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    @Id
    @Column(name=GenZT_GentumiSkMikomirituULFTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return getPrimaryKey().getZtydatakanrino();
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        getPrimaryKey().setZtydatakanrino(pZtydatakanrino);
    }

    private String ztykhsyoumetujiyuu;

    @Column(name=GenZT_GentumiSkMikomirituULFTy.ZTYKHSYOUMETUJIYUU)
    public String getZtykhsyoumetujiyuu() {
        return ztykhsyoumetujiyuu;
    }

    public void setZtykhsyoumetujiyuu(String pZtykhsyoumetujiyuu) {
        ztykhsyoumetujiyuu = pZtykhsyoumetujiyuu;
    }

    private String ztysymtymd;

    @Column(name=GenZT_GentumiSkMikomirituULFTy.ZTYSYMTYMD)
    public String getZtysymtymd() {
        return ztysymtymd;
    }

    public void setZtysymtymd(String pZtysymtymd) {
        ztysymtymd = pZtysymtymd;
    }
}