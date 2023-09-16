package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.def.db.mapping.GenJM_SkNaiyouChk;
import yuyu.def.db.meta.GenQJM_SkNaiyouChk;
import yuyu.def.db.meta.QJM_SkNaiyouChk;

/**
 * 請求内容チェック判定マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SkNaiyouChk}</td><td colspan="3">請求内容チェック判定マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSknaiyouchkkbn sknaiyouchkkbn}</td><td>請求内容チェック区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SKNaiyouChkKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYobidasimototaskkbn yobidasimototaskkbn}</td><td>呼出元タスク区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_YobidasimotoTaskKbn}</td></tr>
 *  <tr><td>msgsyubetu</td><td>メッセージ種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MsgSyubetu C_MsgSyubetu}</td></tr>
 *  <tr><td>sateikaisouyouhikbn</td><td>査定回送要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>keisankahikbn</td><td>計算可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>messageId</td><td>メッセージＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msghikisuunaiyoukbn1</td><td>メッセージ引数内容区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MsgHikisuuNaiyouKbn C_MsgHikisuuNaiyouKbn}</td></tr>
 *  <tr><td>msghikisuu1</td><td>メッセージ引数１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msghikisuunaiyoukbn2</td><td>メッセージ引数内容区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MsgHikisuuNaiyouKbn C_MsgHikisuuNaiyouKbn}</td></tr>
 *  <tr><td>msghikisuu2</td><td>メッセージ引数２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msghikisuunaiyoukbn3</td><td>メッセージ引数内容区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MsgHikisuuNaiyouKbn C_MsgHikisuuNaiyouKbn}</td></tr>
 *  <tr><td>msghikisuu3</td><td>メッセージ引数３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msghikisuunaiyoukbn4</td><td>メッセージ引数内容区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MsgHikisuuNaiyouKbn C_MsgHikisuuNaiyouKbn}</td></tr>
 *  <tr><td>msghikisuu4</td><td>メッセージ引数４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msghikisuunaiyoukbn5</td><td>メッセージ引数内容区分５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MsgHikisuuNaiyouKbn C_MsgHikisuuNaiyouKbn}</td></tr>
 *  <tr><td>msghikisuu5</td><td>メッセージ引数５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_SkNaiyouChk
 * @see     GenJM_SkNaiyouChk
 * @see     QJM_SkNaiyouChk
 * @see     GenQJM_SkNaiyouChk
 */
public class PKJM_SkNaiyouChk extends AbstractExDBPrimaryKey<JM_SkNaiyouChk, PKJM_SkNaiyouChk> {

    private static final long serialVersionUID = 1L;

    public PKJM_SkNaiyouChk() {
    }

    public PKJM_SkNaiyouChk(C_SKNaiyouChkKbn pSknaiyouchkkbn, C_YobidasimotoTaskKbn pYobidasimototaskkbn) {
        sknaiyouchkkbn = pSknaiyouchkkbn;
        yobidasimototaskkbn = pYobidasimototaskkbn;
    }

    @Transient
    @Override
    public Class<JM_SkNaiyouChk> getEntityClass() {
        return JM_SkNaiyouChk.class;
    }

    private C_SKNaiyouChkKbn sknaiyouchkkbn;

    @org.hibernate.annotations.Type(type="UserType_C_SKNaiyouChkKbn")
    public C_SKNaiyouChkKbn getSknaiyouchkkbn() {
        return sknaiyouchkkbn;
    }

    public void setSknaiyouchkkbn(C_SKNaiyouChkKbn pSknaiyouchkkbn) {
        sknaiyouchkkbn = pSknaiyouchkkbn;
    }
    private C_YobidasimotoTaskKbn yobidasimototaskkbn;

    @org.hibernate.annotations.Type(type="UserType_C_YobidasimotoTaskKbn")
    public C_YobidasimotoTaskKbn getYobidasimototaskkbn() {
        return yobidasimototaskkbn;
    }

    public void setYobidasimototaskkbn(C_YobidasimotoTaskKbn pYobidasimototaskkbn) {
        yobidasimototaskkbn = pYobidasimototaskkbn;
    }

}