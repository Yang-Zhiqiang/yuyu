package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.db.mapping.GenJM_SiTyouhyoumsg;
import yuyu.def.db.meta.GenQJM_SiTyouhyoumsg;
import yuyu.def.db.meta.QJM_SiTyouhyoumsg;

/**
 * 支払帳票メッセージマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SiTyouhyoumsg}</td><td colspan="3">支払帳票メッセージマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBunrui1 bunrui1}</td><td>分類１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBunrui2 bunrui2}</td><td>分類２</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyoulineno tyouhyoulineno}</td><td>帳票行番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>setteikasyo</td><td>設定箇所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyouhyoumsg</td><td>帳票メッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_SiTyouhyoumsg
 * @see     GenJM_SiTyouhyoumsg
 * @see     QJM_SiTyouhyoumsg
 * @see     GenQJM_SiTyouhyoumsg
 */
public class PKJM_SiTyouhyoumsg extends AbstractExDBPrimaryKey<JM_SiTyouhyoumsg, PKJM_SiTyouhyoumsg> {

    private static final long serialVersionUID = 1L;

    public PKJM_SiTyouhyoumsg() {
    }

    public PKJM_SiTyouhyoumsg(
        String pBunrui1,
        String pBunrui2,
        Integer pTyouhyoulineno
    ) {
        bunrui1 = pBunrui1;
        bunrui2 = pBunrui2;
        tyouhyoulineno = pTyouhyoulineno;
    }

    @Transient
    @Override
    public Class<JM_SiTyouhyoumsg> getEntityClass() {
        return JM_SiTyouhyoumsg.class;
    }

    private String bunrui1;

    public String getBunrui1() {
        return bunrui1;
    }

    public void setBunrui1(String pBunrui1) {
        bunrui1 = pBunrui1;
    }
    private String bunrui2;

    public String getBunrui2() {
        return bunrui2;
    }

    public void setBunrui2(String pBunrui2) {
        bunrui2 = pBunrui2;
    }
    private Integer tyouhyoulineno;

    public Integer getTyouhyoulineno() {
        return tyouhyoulineno;
    }

    public void setTyouhyoulineno(Integer pTyouhyoulineno) {
        tyouhyoulineno = pTyouhyoulineno;
    }

}