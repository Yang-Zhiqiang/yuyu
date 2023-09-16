package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.db.id.PKJM_SiTyouhyoumsg;
import yuyu.def.db.meta.GenQJM_SiTyouhyoumsg;
import yuyu.def.db.meta.QJM_SiTyouhyoumsg;

/**
 * 支払帳票メッセージマスタ テーブルのマッピング情報クラスで、 {@link JM_SiTyouhyoumsg} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SiTyouhyoumsg}</td><td colspan="3">支払帳票メッセージマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBunrui1 bunrui1}</td><td>分類１</td><td align="center">{@link PKJM_SiTyouhyoumsg ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBunrui2 bunrui2}</td><td>分類２</td><td align="center">{@link PKJM_SiTyouhyoumsg ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyoulineno tyouhyoulineno}</td><td>帳票行番号</td><td align="center">{@link PKJM_SiTyouhyoumsg ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSetteikasyo setteikasyo}</td><td>設定箇所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyoumsg tyouhyoumsg}</td><td>帳票メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_SiTyouhyoumsg
 * @see     PKJM_SiTyouhyoumsg
 * @see     QJM_SiTyouhyoumsg
 * @see     GenQJM_SiTyouhyoumsg
 */
@MappedSuperclass
@Table(name=GenJM_SiTyouhyoumsg.TABLE_NAME)
@IdClass(value=PKJM_SiTyouhyoumsg.class)
public abstract class GenJM_SiTyouhyoumsg extends AbstractExDBEntity<JM_SiTyouhyoumsg, PKJM_SiTyouhyoumsg> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_SiTyouhyoumsg";
    public static final String BUNRUI1                  = "bunrui1";
    public static final String BUNRUI2                  = "bunrui2";
    public static final String TYOUHYOULINENO           = "tyouhyoulineno";
    public static final String SETTEIKASYO              = "setteikasyo";
    public static final String TYOUHYOUMSG              = "tyouhyoumsg";

    private final PKJM_SiTyouhyoumsg primaryKey;

    public GenJM_SiTyouhyoumsg() {
        primaryKey = new PKJM_SiTyouhyoumsg();
    }

    public GenJM_SiTyouhyoumsg(
        String pBunrui1,
        String pBunrui2,
        Integer pTyouhyoulineno
    ) {
        primaryKey = new PKJM_SiTyouhyoumsg(
            pBunrui1,
            pBunrui2,
            pTyouhyoulineno
        );
    }

    @Transient
    @Override
    public PKJM_SiTyouhyoumsg getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_SiTyouhyoumsg> getMetaClass() {
        return QJM_SiTyouhyoumsg.class;
    }

    @Id
    @Column(name=GenJM_SiTyouhyoumsg.BUNRUI1)
    public String getBunrui1() {
        return getPrimaryKey().getBunrui1();
    }

    public void setBunrui1(String pBunrui1) {
        getPrimaryKey().setBunrui1(pBunrui1);
    }

    @Id
    @Column(name=GenJM_SiTyouhyoumsg.BUNRUI2)
    public String getBunrui2() {
        return getPrimaryKey().getBunrui2();
    }

    public void setBunrui2(String pBunrui2) {
        getPrimaryKey().setBunrui2(pBunrui2);
    }

    @Id
    @Column(name=GenJM_SiTyouhyoumsg.TYOUHYOULINENO)
    @Range(min="0", max="999")
    @NaturalNumber
    public Integer getTyouhyoulineno() {
        return getPrimaryKey().getTyouhyoulineno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyoulineno(Integer pTyouhyoulineno) {
        getPrimaryKey().setTyouhyoulineno(pTyouhyoulineno);
    }

    private String setteikasyo;

    @Column(name=GenJM_SiTyouhyoumsg.SETTEIKASYO)
    public String getSetteikasyo() {
        return setteikasyo;
    }

    public void setSetteikasyo(String pSetteikasyo) {
        setteikasyo = pSetteikasyo;
    }

    private String tyouhyoumsg;

    @Column(name=GenJM_SiTyouhyoumsg.TYOUHYOUMSG)
    public String getTyouhyoumsg() {
        return tyouhyoumsg;
    }

    public void setTyouhyoumsg(String pTyouhyoumsg) {
        tyouhyoumsg = pTyouhyoumsg;
    }
}
