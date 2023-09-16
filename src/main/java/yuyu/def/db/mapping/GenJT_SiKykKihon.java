package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Aplkahi;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_Saihoum;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.id.PKJT_SiKykKihon;
import yuyu.def.db.meta.GenQJT_SiKykKihon;
import yuyu.def.db.meta.QJT_SiKykKihon;
import yuyu.def.db.type.UserType_C_Aplkahi;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_KykdrknHtdjytKbn;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_Saihoum;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_StknsetKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_TtdktyuuiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 支払契約基本テーブル（物理テーブルなし） テーブルのマッピング情報クラスで、 {@link JT_SiKykKihon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiKykKihon}</td><td colspan="3">支払契約基本テーブル（物理テーブルなし）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiKykKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAitesyono aitesyono}</td><td>相手証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getSntkhoukbn sntkhoukbn}</td><td>選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkhouKbn}</td></tr>
 *  <tr><td>{@link #getMosymd mosymd}</td><td>申込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKktymd kktymd}</td><td>告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYuukousyoumetukbn yuukousyoumetukbn}</td><td>有効消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>{@link #getKykjyoutai kykjyoutai}</td><td>契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykjyoutai}</td></tr>
 *  <tr><td>{@link #getNexthrkym nexthrkym}</td><td>次回払込年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getYykknmnryymd yykknmnryymd}</td><td>猶予期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKeip keip}</td><td>合計保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSykyknyhenkouymd sykyknyhenkouymd}</td><td>最終契約内容変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLasthkhenkouymd lasthkhenkouymd}</td><td>最終払方変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrketykouryokuhasseiymd hrketykouryokuhasseiymd}</td><td>払済延長効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getStknsetkbn stknsetkbn}</td><td>質権設定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_StknsetKbn}</td></tr>
 *  <tr><td>{@link #getAplkahikbn aplkahikbn}</td><td>ＡＰＬ可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Aplkahi}</td></tr>
 *  <tr><td>{@link #getSbuktnin sbuktnin}</td><td>死亡受取人人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSaihoum saihoum}</td><td>再保有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Saihoum}</td></tr>
 *  <tr><td>{@link #getHksknnkaisiymd hksknnkaisiymd}</td><td>復活責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGnkykfksknnkaisiymd gnkykfksknnkaisiymd}</td><td>原契約復旧責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJidouupdatekahi jidouupdatekahi}</td><td>自動更新可否</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJidouupdategop jidouupdategop}</td><td>自動更新後保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLivingneedshukaumu livingneedshukaumu}</td><td>リビングニーズ特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNstkhkumu nstkhkumu}</td><td>年金支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNkshrtkyknksyukbn nkshrtkyknksyukbn}</td><td>年金支払特約年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nstknsyu}</td></tr>
 *  <tr><td>{@link #getNkshrtkyknksyukkn nkshrtkyknksyukkn}</td><td>年金支払特約年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhkntodouhukencd hhkntodouhukencd}</td><td>被保険者都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTratkityuiumu tratkityuiumu}</td><td>取扱注意有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTratkityuiuny tratkityuiuny}</td><td>取扱注意内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksei kyksei}</td><td>契約者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kyksei}</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykyno kykyno}</td><td>契約者郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKkkyktdk kkkyktdk}</td><td>契約管理契約者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getKykhnkkaisuu kykhnkkaisuu}</td><td>契約者変更回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kn tsinadr1kn}</td><td>通信先住所１（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kn tsinadr2kn}</td><td>通信先住所２（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kn tsinadr3kn}</td><td>通信先住所３（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknyno hhknyno}</td><td>被保険者郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr1kn hhknadr1kn}</td><td>被保険者住所１（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr2kn hhknadr2kn}</td><td>被保険者住所２（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr3kn hhknadr3kn}</td><td>被保険者住所３（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr1kj hhknadr1kj}</td><td>被保険者住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr2kj hhknadr2kj}</td><td>被保険者住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr3kj hhknadr3kj}</td><td>被保険者住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkntelno hhkntelno}</td><td>被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkumu stdrsktkyhkumu}</td><td>被保険者代理特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSiteidruktnmkn siteidruktnmkn}</td><td>指定代理受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiteidruktnmkj siteidruktnmkj}</td><td>指定代理受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiteidrukttdk siteidrukttdk}</td><td>指定代理受取人続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getKykdrtkykhukaumu kykdrtkykhukaumu}</td><td>契約者代理特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykdrknhatudoujyoutai kykdrknhatudoujyoutai}</td><td>契約者代理権発動状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykdrknHtdjytKbn}</td></tr>
 *  <tr><td>{@link #getKykdairinmkj kykdairinmkj}</td><td>契約者代理人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairinmkn kykdairinmkn}</td><td>契約者代理人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdrnmkjkhukakbn kykdrnmkjkhukakbn}</td><td>契約者代理人名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getKykdryno kykdryno}</td><td>契約者代理人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdradr1kj kykdradr1kj}</td><td>契約者代理人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdradr2kj kykdradr2kj}</td><td>契約者代理人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdradr3kj kykdradr3kj}</td><td>契約者代理人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdrseiymd kykdrseiymd}</td><td>契約者代理人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykdrtelno kykdrtelno}</td><td>契約者代理人電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrhousiteikbn shrhousiteikbn}</td><td>支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyuup misyuup}</td><td>未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMisyuupjyuutouym misyuupjyuutouym}</td><td>未収保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMisyuupjytkaisuu misyuupjytkaisuu}</td><td>未収保険料充当回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMikeikap mikeikap}</td><td>未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMikeikapjyuutouym mikeikapjyuutouym}</td><td>未経過保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMikeikapjytkaisuu mikeikapjytkaisuu}</td><td>未経過保険料充当回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHtykeihi htykeihi}</td><td>必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenhtykeihi yenhtykeihi}</td><td>円換算必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrkykhtykeihi shrkykhtykeihi}</td><td>支払時契約者必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKrkgk krkgk}</td><td>仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLastsyosaihkymd lastsyosaihkymd}</td><td>最終証券再発行日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLastmeihenymd lastmeihenymd}</td><td>最終名義変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLastsbukthenymd lastsbukthenymd}</td><td>最終死亡受取人変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn1 ttdktyuuikbn1}</td><td>手続注意区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn2 ttdktyuuikbn2}</td><td>手続注意区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn3 ttdktyuuikbn3}</td><td>手続注意区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn4 ttdktyuuikbn4}</td><td>手続注意区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn5 ttdktyuuikbn5}</td><td>手続注意区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getFstpnyknymd fstpnyknymd}</td><td>初回保険料入金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennouryosyuymd zennouryosyuymd}</td><td>前納領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiKykKihon
 * @see     PKJT_SiKykKihon
 * @see     QJT_SiKykKihon
 * @see     GenQJT_SiKykKihon
 */
@MappedSuperclass
@Table(name=GenJT_SiKykKihon.TABLE_NAME)
@IdClass(value=PKJT_SiKykKihon.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Aplkahi", typeClass=UserType_C_Aplkahi.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_KykdrknHtdjytKbn", typeClass=UserType_C_KykdrknHtdjytKbn.class),
    @TypeDef(name="UserType_C_Kykjyoutai", typeClass=UserType_C_Kykjyoutai.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class),
    @TypeDef(name="UserType_C_Nstknsyu", typeClass=UserType_C_Nstknsyu.class),
    @TypeDef(name="UserType_C_Saihoum", typeClass=UserType_C_Saihoum.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_ShrhousiteiKbn", typeClass=UserType_C_ShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_SntkhouKbn", typeClass=UserType_C_SntkhouKbn.class),
    @TypeDef(name="UserType_C_StknsetKbn", typeClass=UserType_C_StknsetKbn.class),
    @TypeDef(name="UserType_C_Syoumetujiyuu", typeClass=UserType_C_Syoumetujiyuu.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_TtdktyuuiKbn", typeClass=UserType_C_TtdktyuuiKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class),
    @TypeDef(name="UserType_C_YuukousyoumetuKbn", typeClass=UserType_C_YuukousyoumetuKbn.class)
})
public abstract class GenJT_SiKykKihon extends AbstractExDBEntity<JT_SiKykKihon, PKJT_SiKykKihon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiKykKihon";
    public static final String SYONO                    = "syono";
    public static final String AITESYONO                = "aitesyono";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String SNTKHOUKBN               = "sntkhoukbn";
    public static final String MOSYMD                   = "mosymd";
    public static final String KKTYMD                   = "kktymd";
    public static final String YUUKOUSYOUMETUKBN        = "yuukousyoumetukbn";
    public static final String KYKJYOUTAI               = "kykjyoutai";
    public static final String NEXTHRKYM                = "nexthrkym";
    public static final String YYKKNMNRYYMD             = "yykknmnryymd";
    public static final String KEIP                     = "keip";
    public static final String SYKYKNYHENKOUYMD         = "sykyknyhenkouymd";
    public static final String LASTHKHENKOUYMD          = "lasthkhenkouymd";
    public static final String SYOUMETUJIYUU            = "syoumetujiyuu";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String HRKETYKOURYOKUHASSEIYMD  = "hrketykouryokuhasseiymd";
    public static final String STKNSETKBN               = "stknsetkbn";
    public static final String APLKAHIKBN               = "aplkahikbn";
    public static final String SBUKTNIN                 = "sbuktnin";
    public static final String SAIHOUM                  = "saihoum";
    public static final String HKSKNNKAISIYMD           = "hksknnkaisiymd";
    public static final String GNKYKFKSKNNKAISIYMD      = "gnkykfksknnkaisiymd";
    public static final String JIDOUUPDATEKAHI          = "jidouupdatekahi";
    public static final String JIDOUUPDATEGOP           = "jidouupdategop";
    public static final String LIVINGNEEDSHUKAUMU       = "livingneedshukaumu";
    public static final String NSTKHKUMU                = "nstkhkumu";
    public static final String NKSHRTKYKNKSYUKBN        = "nkshrtkyknksyukbn";
    public static final String NKSHRTKYKNKSYUKKN        = "nkshrtkyknksyukkn";
    public static final String HHKNTODOUHUKENCD         = "hhkntodouhukencd";
    public static final String TRATKITYUIUMU            = "tratkityuiumu";
    public static final String TRATKITYUIUNY            = "tratkityuiuny";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKSEI                   = "kyksei";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKYNO                   = "kykyno";
    public static final String KKKYKTDK                 = "kkkyktdk";
    public static final String KYKHNKKAISUU             = "kykhnkkaisuu";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KN               = "tsinadr1kn";
    public static final String TSINADR2KN               = "tsinadr2kn";
    public static final String TSINADR3KN               = "tsinadr3kn";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNYNO                  = "hhknyno";
    public static final String HHKNADR1KN               = "hhknadr1kn";
    public static final String HHKNADR2KN               = "hhknadr2kn";
    public static final String HHKNADR3KN               = "hhknadr3kn";
    public static final String HHKNADR1KJ               = "hhknadr1kj";
    public static final String HHKNADR2KJ               = "hhknadr2kj";
    public static final String HHKNADR3KJ               = "hhknadr3kj";
    public static final String HHKNTELNO                = "hhkntelno";
    public static final String STDRSKTKYHKUMU           = "stdrsktkyhkumu";
    public static final String SITEIDRUKTNMKN           = "siteidruktnmkn";
    public static final String SITEIDRUKTNMKJ           = "siteidruktnmkj";
    public static final String SITEIDRUKTTDK            = "siteidrukttdk";
    public static final String KYKDRTKYKHUKAUMU         = "kykdrtkykhukaumu";
    public static final String KYKDRKNHATUDOUJYOUTAI    = "kykdrknhatudoujyoutai";
    public static final String KYKDAIRINMKJ             = "kykdairinmkj";
    public static final String KYKDAIRINMKN             = "kykdairinmkn";
    public static final String KYKDRNMKJKHUKAKBN        = "kykdrnmkjkhukakbn";
    public static final String KYKDRYNO                 = "kykdryno";
    public static final String KYKDRADR1KJ              = "kykdradr1kj";
    public static final String KYKDRADR2KJ              = "kykdradr2kj";
    public static final String KYKDRADR3KJ              = "kykdradr3kj";
    public static final String KYKDRSEIYMD              = "kykdrseiymd";
    public static final String KYKDRTELNO               = "kykdrtelno";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String SHRHOUSITEIKBN           = "shrhousiteikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String DRTENCD                  = "drtencd";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String BOSYUUCD                 = "bosyuucd";
    public static final String MISYUUP                  = "misyuup";
    public static final String MISYUUPJYUUTOUYM         = "misyuupjyuutouym";
    public static final String MISYUUPJYTKAISUU         = "misyuupjytkaisuu";
    public static final String MIKEIKAP                 = "mikeikap";
    public static final String MIKEIKAPJYUUTOUYM        = "mikeikapjyuutouym";
    public static final String MIKEIKAPJYTKAISUU        = "mikeikapjytkaisuu";
    public static final String HTYKEIHI                 = "htykeihi";
    public static final String YENHTYKEIHI              = "yenhtykeihi";
    public static final String SHRKYKHTYKEIHI           = "shrkykhtykeihi";
    public static final String KRKGK                    = "krkgk";
    public static final String LASTSYOSAIHKYMD          = "lastsyosaihkymd";
    public static final String LASTMEIHENYMD            = "lastmeihenymd";
    public static final String LASTSBUKTHENYMD          = "lastsbukthenymd";
    public static final String TTDKTYUUIKBN1            = "ttdktyuuikbn1";
    public static final String TTDKTYUUIKBN2            = "ttdktyuuikbn2";
    public static final String TTDKTYUUIKBN3            = "ttdktyuuikbn3";
    public static final String TTDKTYUUIKBN4            = "ttdktyuuikbn4";
    public static final String TTDKTYUUIKBN5            = "ttdktyuuikbn5";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";
    public static final String FSTPNYKNYMD              = "fstpnyknymd";
    public static final String ZENNOURYOSYUYMD          = "zennouryosyuymd";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiKykKihon primaryKey;

    public GenJT_SiKykKihon() {
        primaryKey = new PKJT_SiKykKihon();
    }

    public GenJT_SiKykKihon(String pSyono) {
        primaryKey = new PKJT_SiKykKihon(pSyono);
    }

    @Transient
    @Override
    public PKJT_SiKykKihon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiKykKihon> getMetaClass() {
        return QJT_SiKykKihon.class;
    }

    @Id
    @Column(name=GenJT_SiKykKihon.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String aitesyono;

    @Column(name=GenJT_SiKykKihon.AITESYONO)
    @SyoukenNo
    public String getAitesyono() {
        return aitesyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAitesyono(String pAitesyono) {
        aitesyono = pAitesyono;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenJT_SiKykKihon.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenJT_SiKykKihon.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_SntkhouKbn sntkhoukbn;

    @Type(type="UserType_C_SntkhouKbn")
    @Column(name=GenJT_SiKykKihon.SNTKHOUKBN)
    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    private BizDate mosymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.MOSYMD)
    @ValidDate
    public BizDate getMosymd() {
        return mosymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    private BizDate kktymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.KKTYMD)
    @ValidDate
    public BizDate getKktymd() {
        return kktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktymd(BizDate pKktymd) {
        kktymd = pKktymd;
    }

    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Type(type="UserType_C_YuukousyoumetuKbn")
    @Column(name=GenJT_SiKykKihon.YUUKOUSYOUMETUKBN)
    public C_YuukousyoumetuKbn getYuukousyoumetukbn() {
        return yuukousyoumetukbn;
    }

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {
        yuukousyoumetukbn = pYuukousyoumetukbn;
    }

    private C_Kykjyoutai kykjyoutai;

    @Type(type="UserType_C_Kykjyoutai")
    @Column(name=GenJT_SiKykKihon.KYKJYOUTAI)
    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    private BizDateYM nexthrkym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_SiKykKihon.NEXTHRKYM)
    public BizDateYM getNexthrkym() {
        return nexthrkym;
    }

    public void setNexthrkym(BizDateYM pNexthrkym) {
        nexthrkym = pNexthrkym;
    }

    private BizDate yykknmnryymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.YYKKNMNRYYMD)
    public BizDate getYykknmnryymd() {
        return yykknmnryymd;
    }

    @Trim("both")
    public void setYykknmnryymd(BizDate pYykknmnryymd) {
        yykknmnryymd = pYykknmnryymd;
    }

    private BizCurrency keip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKeip() {
        return keip;
    }

    public void setKeip(BizCurrency pKeip) {
        keip = pKeip;
        keipValue = null;
        keipType  = null;
    }

    transient private BigDecimal keipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KEIP, nullable=true)
    protected BigDecimal getKeipValue() {
        if (keipValue == null && keip != null) {
            if (keip.isOptional()) return null;
            return keip.absolute();
        }
        return keipValue;
    }

    protected void setKeipValue(BigDecimal value) {
        keipValue = value;
        keip = Optional.fromNullable(toCurrencyType(keipType))
            .transform(bizCurrencyTransformer(getKeipValue()))
            .orNull();
    }

    transient private String keipType = null;

    @Column(name=KEIP + "$", nullable=true)
    protected String getKeipType() {
        if (keipType == null && keip != null) return keip.getType().toString();
        if (keipType == null && getKeipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'keip$' should not be NULL."));
        }
        return keipType;
    }

    protected void setKeipType(String type) {
        keipType = type;
        keip = Optional.fromNullable(toCurrencyType(keipType))
            .transform(bizCurrencyTransformer(getKeipValue()))
            .orNull();
    }

    private BizDate sykyknyhenkouymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.SYKYKNYHENKOUYMD)
    public BizDate getSykyknyhenkouymd() {
        return sykyknyhenkouymd;
    }

    public void setSykyknyhenkouymd(BizDate pSykyknyhenkouymd) {
        sykyknyhenkouymd = pSykyknyhenkouymd;
    }

    private BizDate lasthkhenkouymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.LASTHKHENKOUYMD)
    @ValidDate
    public BizDate getLasthkhenkouymd() {
        return lasthkhenkouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLasthkhenkouymd(BizDate pLasthkhenkouymd) {
        lasthkhenkouymd = pLasthkhenkouymd;
    }

    private C_Syoumetujiyuu syoumetujiyuu;

    @Type(type="UserType_C_Syoumetujiyuu")
    @Column(name=GenJT_SiKykKihon.SYOUMETUJIYUU)
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private BizDate hrketykouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.HRKETYKOURYOKUHASSEIYMD)
    public BizDate getHrketykouryokuhasseiymd() {
        return hrketykouryokuhasseiymd;
    }

    public void setHrketykouryokuhasseiymd(BizDate pHrketykouryokuhasseiymd) {
        hrketykouryokuhasseiymd = pHrketykouryokuhasseiymd;
    }

    private C_StknsetKbn stknsetkbn;

    @Type(type="UserType_C_StknsetKbn")
    @Column(name=GenJT_SiKykKihon.STKNSETKBN)
    public C_StknsetKbn getStknsetkbn() {
        return stknsetkbn;
    }

    public void setStknsetkbn(C_StknsetKbn pStknsetkbn) {
        stknsetkbn = pStknsetkbn;
    }

    private C_Aplkahi aplkahikbn;

    @Type(type="UserType_C_Aplkahi")
    @Column(name=GenJT_SiKykKihon.APLKAHIKBN)
    public C_Aplkahi getAplkahikbn() {
        return aplkahikbn;
    }

    public void setAplkahikbn(C_Aplkahi pAplkahikbn) {
        aplkahikbn = pAplkahikbn;
    }

    private Integer sbuktnin;

    @Column(name=GenJT_SiKykKihon.SBUKTNIN)
    @Range(min="0", max="99")
    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktnin(Integer pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    private C_Saihoum saihoum;

    @Type(type="UserType_C_Saihoum")
    @Column(name=GenJT_SiKykKihon.SAIHOUM)
    public C_Saihoum getSaihoum() {
        return saihoum;
    }

    public void setSaihoum(C_Saihoum pSaihoum) {
        saihoum = pSaihoum;
    }

    private BizDate hksknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.HKSKNNKAISIYMD)
    public BizDate getHksknnkaisiymd() {
        return hksknnkaisiymd;
    }

    public void setHksknnkaisiymd(BizDate pHksknnkaisiymd) {
        hksknnkaisiymd = pHksknnkaisiymd;
    }

    private BizDate gnkykfksknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.GNKYKFKSKNNKAISIYMD)
    public BizDate getGnkykfksknnkaisiymd() {
        return gnkykfksknnkaisiymd;
    }

    public void setGnkykfksknnkaisiymd(BizDate pGnkykfksknnkaisiymd) {
        gnkykfksknnkaisiymd = pGnkykfksknnkaisiymd;
    }

    private Integer jidouupdatekahi;

    @Column(name=GenJT_SiKykKihon.JIDOUUPDATEKAHI)
    public Integer getJidouupdatekahi() {
        return jidouupdatekahi;
    }

    public void setJidouupdatekahi(Integer pJidouupdatekahi) {
        jidouupdatekahi = pJidouupdatekahi;
    }

    private BizCurrency jidouupdategop;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getJidouupdategop() {
        return jidouupdategop;
    }

    public void setJidouupdategop(BizCurrency pJidouupdategop) {
        jidouupdategop = pJidouupdategop;
        jidouupdategopValue = null;
        jidouupdategopType  = null;
    }

    transient private BigDecimal jidouupdategopValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=JIDOUUPDATEGOP, nullable=true)
    protected BigDecimal getJidouupdategopValue() {
        if (jidouupdategopValue == null && jidouupdategop != null) {
            if (jidouupdategop.isOptional()) return null;
            return jidouupdategop.absolute();
        }
        return jidouupdategopValue;
    }

    protected void setJidouupdategopValue(BigDecimal value) {
        jidouupdategopValue = value;
        jidouupdategop = Optional.fromNullable(toCurrencyType(jidouupdategopType))
            .transform(bizCurrencyTransformer(getJidouupdategopValue()))
            .orNull();
    }

    transient private String jidouupdategopType = null;

    @Column(name=JIDOUUPDATEGOP + "$", nullable=true)
    protected String getJidouupdategopType() {
        if (jidouupdategopType == null && jidouupdategop != null) return jidouupdategop.getType().toString();
        if (jidouupdategopType == null && getJidouupdategopValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'jidouupdategop$' should not be NULL."));
        }
        return jidouupdategopType;
    }

    protected void setJidouupdategopType(String type) {
        jidouupdategopType = type;
        jidouupdategop = Optional.fromNullable(toCurrencyType(jidouupdategopType))
            .transform(bizCurrencyTransformer(getJidouupdategopValue()))
            .orNull();
    }

    private C_UmuKbn livingneedshukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiKykKihon.LIVINGNEEDSHUKAUMU)
    public C_UmuKbn getLivingneedshukaumu() {
        return livingneedshukaumu;
    }

    public void setLivingneedshukaumu(C_UmuKbn pLivingneedshukaumu) {
        livingneedshukaumu = pLivingneedshukaumu;
    }

    private C_UmuKbn nstkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiKykKihon.NSTKHKUMU)
    public C_UmuKbn getNstkhkumu() {
        return nstkhkumu;
    }

    public void setNstkhkumu(C_UmuKbn pNstkhkumu) {
        nstkhkumu = pNstkhkumu;
    }

    private C_Nstknsyu nkshrtkyknksyukbn;

    @Type(type="UserType_C_Nstknsyu")
    @Column(name=GenJT_SiKykKihon.NKSHRTKYKNKSYUKBN)
    public C_Nstknsyu getNkshrtkyknksyukbn() {
        return nkshrtkyknksyukbn;
    }

    public void setNkshrtkyknksyukbn(C_Nstknsyu pNkshrtkyknksyukbn) {
        nkshrtkyknksyukbn = pNkshrtkyknksyukbn;
    }

    private Integer nkshrtkyknksyukkn;

    @Column(name=GenJT_SiKykKihon.NKSHRTKYKNKSYUKKN)
    @Range(min="0", max="99")
    public Integer getNkshrtkyknksyukkn() {
        return nkshrtkyknksyukkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkshrtkyknksyukkn(Integer pNkshrtkyknksyukkn) {
        nkshrtkyknksyukkn = pNkshrtkyknksyukkn;
    }

    private String hhkntodouhukencd;

    @Column(name=GenJT_SiKykKihon.HHKNTODOUHUKENCD)
    public String getHhkntodouhukencd() {
        return hhkntodouhukencd;
    }

    public void setHhkntodouhukencd(String pHhkntodouhukencd) {
        hhkntodouhukencd = pHhkntodouhukencd;
    }

    private C_UmuKbn tratkityuiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiKykKihon.TRATKITYUIUMU)
    public C_UmuKbn getTratkityuiumu() {
        return tratkityuiumu;
    }

    public void setTratkityuiumu(C_UmuKbn pTratkityuiumu) {
        tratkityuiumu = pTratkityuiumu;
    }

    private String tratkityuiuny;

    @Column(name=GenJT_SiKykKihon.TRATKITYUIUNY)
    public String getTratkityuiuny() {
        return tratkityuiuny;
    }

    public void setTratkityuiuny(String pTratkityuiuny) {
        tratkityuiuny = pTratkityuiuny;
    }

    private String kyknmkn;

    @Column(name=GenJT_SiKykKihon.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String kyknmkj;

    @Column(name=GenJT_SiKykKihon.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private C_Kyksei kyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenJT_SiKykKihon.KYKSEI)
    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private String kykyno;

    @Column(name=GenJT_SiKykKihon.KYKYNO)
    public String getKykyno() {
        return kykyno;
    }

    public void setKykyno(String pKykyno) {
        kykyno = pKykyno;
    }

    private C_Tdk kkkyktdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenJT_SiKykKihon.KKKYKTDK)
    public C_Tdk getKkkyktdk() {
        return kkkyktdk;
    }

    public void setKkkyktdk(C_Tdk pKkkyktdk) {
        kkkyktdk = pKkkyktdk;
    }

    private Integer kykhnkkaisuu;

    @Column(name=GenJT_SiKykKihon.KYKHNKKAISUU)
    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    private String tsinyno;

    @Column(name=GenJT_SiKykKihon.TSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private String tsinadr1kn;

    @Column(name=GenJT_SiKykKihon.TSINADR1KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kn() {
        return tsinadr1kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kn(String pTsinadr1kn) {
        tsinadr1kn = pTsinadr1kn;
    }

    private String tsinadr2kn;

    @Column(name=GenJT_SiKykKihon.TSINADR2KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kn() {
        return tsinadr2kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kn(String pTsinadr2kn) {
        tsinadr2kn = pTsinadr2kn;
    }

    private String tsinadr3kn;

    @Column(name=GenJT_SiKykKihon.TSINADR3KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kn() {
        return tsinadr3kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kn(String pTsinadr3kn) {
        tsinadr3kn = pTsinadr3kn;
    }

    private String tsinadr1kj;

    @Column(name=GenJT_SiKykKihon.TSINADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    private String tsinadr2kj;

    @Column(name=GenJT_SiKykKihon.TSINADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    private String tsinadr3kj;

    @Column(name=GenJT_SiKykKihon.TSINADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    private String tsintelno;

    @Column(name=GenJT_SiKykKihon.TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    private String hhknnmkn;

    @Column(name=GenJT_SiKykKihon.HHKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    private String hhknnmkj;

    @Column(name=GenJT_SiKykKihon.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenJT_SiKykKihon.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private String hhknyno;

    @Column(name=GenJT_SiKykKihon.HHKNYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getHhknyno() {
        return hhknyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    private String hhknadr1kn;

    @Column(name=GenJT_SiKykKihon.HHKNADR1KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr1kn() {
        return hhknadr1kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr1kn(String pHhknadr1kn) {
        hhknadr1kn = pHhknadr1kn;
    }

    private String hhknadr2kn;

    @Column(name=GenJT_SiKykKihon.HHKNADR2KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr2kn() {
        return hhknadr2kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr2kn(String pHhknadr2kn) {
        hhknadr2kn = pHhknadr2kn;
    }

    private String hhknadr3kn;

    @Column(name=GenJT_SiKykKihon.HHKNADR3KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr3kn() {
        return hhknadr3kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr3kn(String pHhknadr3kn) {
        hhknadr3kn = pHhknadr3kn;
    }

    private String hhknadr1kj;

    @Column(name=GenJT_SiKykKihon.HHKNADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr1kj() {
        return hhknadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr1kj(String pHhknadr1kj) {
        hhknadr1kj = pHhknadr1kj;
    }

    private String hhknadr2kj;

    @Column(name=GenJT_SiKykKihon.HHKNADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr2kj() {
        return hhknadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr2kj(String pHhknadr2kj) {
        hhknadr2kj = pHhknadr2kj;
    }

    private String hhknadr3kj;

    @Column(name=GenJT_SiKykKihon.HHKNADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr3kj() {
        return hhknadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr3kj(String pHhknadr3kj) {
        hhknadr3kj = pHhknadr3kj;
    }

    private String hhkntelno;

    @Column(name=GenJT_SiKykKihon.HHKNTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getHhkntelno() {
        return hhkntelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntelno(String pHhkntelno) {
        hhkntelno = pHhkntelno;
    }

    private C_UmuKbn stdrsktkyhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiKykKihon.STDRSKTKYHKUMU)
    public C_UmuKbn getStdrsktkyhkumu() {
        return stdrsktkyhkumu;
    }

    public void setStdrsktkyhkumu(C_UmuKbn pStdrsktkyhkumu) {
        stdrsktkyhkumu = pStdrsktkyhkumu;
    }

    private String siteidruktnmkn;

    @Column(name=GenJT_SiKykKihon.SITEIDRUKTNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSiteidruktnmkn() {
        return siteidruktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSiteidruktnmkn(String pSiteidruktnmkn) {
        siteidruktnmkn = pSiteidruktnmkn;
    }

    private String siteidruktnmkj;

    @Column(name=GenJT_SiKykKihon.SITEIDRUKTNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSiteidruktnmkj() {
        return siteidruktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSiteidruktnmkj(String pSiteidruktnmkj) {
        siteidruktnmkj = pSiteidruktnmkj;
    }

    private C_Tdk siteidrukttdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenJT_SiKykKihon.SITEIDRUKTTDK)
    public C_Tdk getSiteidrukttdk() {
        return siteidrukttdk;
    }

    public void setSiteidrukttdk(C_Tdk pSiteidrukttdk) {
        siteidrukttdk = pSiteidrukttdk;
    }

    private C_UmuKbn kykdrtkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiKykKihon.KYKDRTKYKHUKAUMU)
    public C_UmuKbn getKykdrtkykhukaumu() {
        return kykdrtkykhukaumu;
    }

    public void setKykdrtkykhukaumu(C_UmuKbn pKykdrtkykhukaumu) {
        kykdrtkykhukaumu = pKykdrtkykhukaumu;
    }

    private C_KykdrknHtdjytKbn kykdrknhatudoujyoutai;

    @Type(type="UserType_C_KykdrknHtdjytKbn")
    @Column(name=GenJT_SiKykKihon.KYKDRKNHATUDOUJYOUTAI)
    public C_KykdrknHtdjytKbn getKykdrknhatudoujyoutai() {
        return kykdrknhatudoujyoutai;
    }

    public void setKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn pKykdrknhatudoujyoutai) {
        kykdrknhatudoujyoutai = pKykdrknhatudoujyoutai;
    }

    private String kykdairinmkj;

    @Column(name=GenJT_SiKykKihon.KYKDAIRINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdairinmkj() {
        return kykdairinmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykdairinmkj(String pKykdairinmkj) {
        kykdairinmkj = pKykdairinmkj;
    }

    private String kykdairinmkn;

    @Column(name=GenJT_SiKykKihon.KYKDAIRINMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKykdairinmkn() {
        return kykdairinmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykdairinmkn(String pKykdairinmkn) {
        kykdairinmkn = pKykdairinmkn;
    }

    private C_KjkhukaKbn kykdrnmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenJT_SiKykKihon.KYKDRNMKJKHUKAKBN)
    public C_KjkhukaKbn getKykdrnmkjkhukakbn() {
        return kykdrnmkjkhukakbn;
    }

    public void setKykdrnmkjkhukakbn(C_KjkhukaKbn pKykdrnmkjkhukakbn) {
        kykdrnmkjkhukakbn = pKykdrnmkjkhukakbn;
    }

    private String kykdryno;

    @Column(name=GenJT_SiKykKihon.KYKDRYNO)
    @Length(length=7)
    @Digit
    public String getKykdryno() {
        return kykdryno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdryno(String pKykdryno) {
        kykdryno = pKykdryno;
    }

    private String kykdradr1kj;

    @Column(name=GenJT_SiKykKihon.KYKDRADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdradr1kj() {
        return kykdradr1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr1kj(String pKykdradr1kj) {
        kykdradr1kj = pKykdradr1kj;
    }

    private String kykdradr2kj;

    @Column(name=GenJT_SiKykKihon.KYKDRADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdradr2kj() {
        return kykdradr2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr2kj(String pKykdradr2kj) {
        kykdradr2kj = pKykdradr2kj;
    }

    private String kykdradr3kj;

    @Column(name=GenJT_SiKykKihon.KYKDRADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdradr3kj() {
        return kykdradr3kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr3kj(String pKykdradr3kj) {
        kykdradr3kj = pKykdradr3kj;
    }

    private BizDate kykdrseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.KYKDRSEIYMD)
    @ValidDate
    public BizDate getKykdrseiymd() {
        return kykdrseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrseiymd(BizDate pKykdrseiymd) {
        kykdrseiymd = pKykdrseiymd;
    }

    private String kykdrtelno;

    @Column(name=GenJT_SiKykKihon.KYKDRTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getKykdrtelno() {
        return kykdrtelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrtelno(String pKykdrtelno) {
        kykdrtelno = pKykdrtelno;
    }

    private String kzmeiginmkn;

    @Column(name=GenJT_SiKykKihon.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    @Type(type="UserType_C_ShrhousiteiKbn")
    @Column(name=GenJT_SiKykKihon.SHRHOUSITEIKBN)
    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    private String bankcd;

    @Column(name=GenJT_SiKykKihon.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd;

    @Column(name=GenJT_SiKykKihon.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenJT_SiKykKihon.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenJT_SiKykKihon.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private String drtencd;

    @Column(name=GenJT_SiKykKihon.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    private String oyadrtencd;

    @Column(name=GenJT_SiKykKihon.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    private String drtenkanrisosikicd;

    @Column(name=GenJT_SiKykKihon.DRTENKANRISOSIKICD)
    @HostInvalidCharacter
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private String bosyuucd;

    @Column(name=GenJT_SiKykKihon.BOSYUUCD)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd() {
        return bosyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd(String pBosyuucd) {
        bosyuucd = pBosyuucd;
    }

    private BizCurrency misyuup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
        misyuupValue = null;
        misyuupType  = null;
    }

    transient private BigDecimal misyuupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MISYUUP, nullable=true)
    protected BigDecimal getMisyuupValue() {
        if (misyuupValue == null && misyuup != null) {
            if (misyuup.isOptional()) return null;
            return misyuup.absolute();
        }
        return misyuupValue;
    }

    protected void setMisyuupValue(BigDecimal value) {
        misyuupValue = value;
        misyuup = Optional.fromNullable(toCurrencyType(misyuupType))
            .transform(bizCurrencyTransformer(getMisyuupValue()))
            .orNull();
    }

    transient private String misyuupType = null;

    @Column(name=MISYUUP + "$", nullable=true)
    protected String getMisyuupType() {
        if (misyuupType == null && misyuup != null) return misyuup.getType().toString();
        if (misyuupType == null && getMisyuupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'misyuup$' should not be NULL."));
        }
        return misyuupType;
    }

    protected void setMisyuupType(String type) {
        misyuupType = type;
        misyuup = Optional.fromNullable(toCurrencyType(misyuupType))
            .transform(bizCurrencyTransformer(getMisyuupValue()))
            .orNull();
    }

    private BizDateYM misyuupjyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_SiKykKihon.MISYUUPJYUUTOUYM)
    public BizDateYM getMisyuupjyuutouym() {
        return misyuupjyuutouym;
    }

    public void setMisyuupjyuutouym(BizDateYM pMisyuupjyuutouym) {
        misyuupjyuutouym = pMisyuupjyuutouym;
    }

    private Integer misyuupjytkaisuu;

    @Column(name=GenJT_SiKykKihon.MISYUUPJYTKAISUU)
    public Integer getMisyuupjytkaisuu() {
        return misyuupjytkaisuu;
    }

    public void setMisyuupjytkaisuu(Integer pMisyuupjytkaisuu) {
        misyuupjytkaisuu = pMisyuupjytkaisuu;
    }

    private BizCurrency mikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
        mikeikapValue = null;
        mikeikapType  = null;
    }

    transient private BigDecimal mikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MIKEIKAP, nullable=true)
    protected BigDecimal getMikeikapValue() {
        if (mikeikapValue == null && mikeikap != null) {
            if (mikeikap.isOptional()) return null;
            return mikeikap.absolute();
        }
        return mikeikapValue;
    }

    protected void setMikeikapValue(BigDecimal value) {
        mikeikapValue = value;
        mikeikap = Optional.fromNullable(toCurrencyType(mikeikapType))
            .transform(bizCurrencyTransformer(getMikeikapValue()))
            .orNull();
    }

    transient private String mikeikapType = null;

    @Column(name=MIKEIKAP + "$", nullable=true)
    protected String getMikeikapType() {
        if (mikeikapType == null && mikeikap != null) return mikeikap.getType().toString();
        if (mikeikapType == null && getMikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mikeikap$' should not be NULL."));
        }
        return mikeikapType;
    }

    protected void setMikeikapType(String type) {
        mikeikapType = type;
        mikeikap = Optional.fromNullable(toCurrencyType(mikeikapType))
            .transform(bizCurrencyTransformer(getMikeikapValue()))
            .orNull();
    }

    private BizDateYM mikeikapjyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_SiKykKihon.MIKEIKAPJYUUTOUYM)
    public BizDateYM getMikeikapjyuutouym() {
        return mikeikapjyuutouym;
    }

    public void setMikeikapjyuutouym(BizDateYM pMikeikapjyuutouym) {
        mikeikapjyuutouym = pMikeikapjyuutouym;
    }

    private Integer mikeikapjytkaisuu;

    @Column(name=GenJT_SiKykKihon.MIKEIKAPJYTKAISUU)
    public Integer getMikeikapjytkaisuu() {
        return mikeikapjytkaisuu;
    }

    public void setMikeikapjytkaisuu(Integer pMikeikapjytkaisuu) {
        mikeikapjytkaisuu = pMikeikapjytkaisuu;
    }

    private BizCurrency htykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
        htykeihiValue = null;
        htykeihiType  = null;
    }

    transient private BigDecimal htykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HTYKEIHI, nullable=true)
    protected BigDecimal getHtykeihiValue() {
        if (htykeihiValue == null && htykeihi != null) {
            if (htykeihi.isOptional()) return null;
            return htykeihi.absolute();
        }
        return htykeihiValue;
    }

    protected void setHtykeihiValue(BigDecimal value) {
        htykeihiValue = value;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    transient private String htykeihiType = null;

    @Column(name=HTYKEIHI + "$", nullable=true)
    protected String getHtykeihiType() {
        if (htykeihiType == null && htykeihi != null) return htykeihi.getType().toString();
        if (htykeihiType == null && getHtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'htykeihi$' should not be NULL."));
        }
        return htykeihiType;
    }

    protected void setHtykeihiType(String type) {
        htykeihiType = type;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    private BizCurrency yenhtykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenhtykeihi() {
        return yenhtykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhtykeihi(BizCurrency pYenhtykeihi) {
        yenhtykeihi = pYenhtykeihi;
        yenhtykeihiValue = null;
        yenhtykeihiType  = null;
    }

    transient private BigDecimal yenhtykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENHTYKEIHI, nullable=true)
    protected BigDecimal getYenhtykeihiValue() {
        if (yenhtykeihiValue == null && yenhtykeihi != null) {
            if (yenhtykeihi.isOptional()) return null;
            return yenhtykeihi.absolute();
        }
        return yenhtykeihiValue;
    }

    protected void setYenhtykeihiValue(BigDecimal value) {
        yenhtykeihiValue = value;
        yenhtykeihi = Optional.fromNullable(toCurrencyType(yenhtykeihiType))
            .transform(bizCurrencyTransformer(getYenhtykeihiValue()))
            .orNull();
    }

    transient private String yenhtykeihiType = null;

    @Column(name=YENHTYKEIHI + "$", nullable=true)
    protected String getYenhtykeihiType() {
        if (yenhtykeihiType == null && yenhtykeihi != null) return yenhtykeihi.getType().toString();
        if (yenhtykeihiType == null && getYenhtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenhtykeihi$' should not be NULL."));
        }
        return yenhtykeihiType;
    }

    protected void setYenhtykeihiType(String type) {
        yenhtykeihiType = type;
        yenhtykeihi = Optional.fromNullable(toCurrencyType(yenhtykeihiType))
            .transform(bizCurrencyTransformer(getYenhtykeihiValue()))
            .orNull();
    }

    private BizCurrency shrkykhtykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrkykhtykeihi() {
        return shrkykhtykeihi;
    }

    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi) {
        shrkykhtykeihi = pShrkykhtykeihi;
        shrkykhtykeihiValue = null;
        shrkykhtykeihiType  = null;
    }

    transient private BigDecimal shrkykhtykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRKYKHTYKEIHI, nullable=true)
    protected BigDecimal getShrkykhtykeihiValue() {
        if (shrkykhtykeihiValue == null && shrkykhtykeihi != null) {
            if (shrkykhtykeihi.isOptional()) return null;
            return shrkykhtykeihi.absolute();
        }
        return shrkykhtykeihiValue;
    }

    protected void setShrkykhtykeihiValue(BigDecimal value) {
        shrkykhtykeihiValue = value;
        shrkykhtykeihi = Optional.fromNullable(toCurrencyType(shrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getShrkykhtykeihiValue()))
            .orNull();
    }

    transient private String shrkykhtykeihiType = null;

    @Column(name=SHRKYKHTYKEIHI + "$", nullable=true)
    protected String getShrkykhtykeihiType() {
        if (shrkykhtykeihiType == null && shrkykhtykeihi != null) return shrkykhtykeihi.getType().toString();
        if (shrkykhtykeihiType == null && getShrkykhtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrkykhtykeihi$' should not be NULL."));
        }
        return shrkykhtykeihiType;
    }

    protected void setShrkykhtykeihiType(String type) {
        shrkykhtykeihiType = type;
        shrkykhtykeihi = Optional.fromNullable(toCurrencyType(shrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getShrkykhtykeihiValue()))
            .orNull();
    }

    private BizCurrency krkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKrkgk() {
        return krkgk;
    }

    public void setKrkgk(BizCurrency pKrkgk) {
        krkgk = pKrkgk;
        krkgkValue = null;
        krkgkType  = null;
    }

    transient private BigDecimal krkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KRKGK, nullable=true)
    protected BigDecimal getKrkgkValue() {
        if (krkgkValue == null && krkgk != null) {
            if (krkgk.isOptional()) return null;
            return krkgk.absolute();
        }
        return krkgkValue;
    }

    protected void setKrkgkValue(BigDecimal value) {
        krkgkValue = value;
        krkgk = Optional.fromNullable(toCurrencyType(krkgkType))
            .transform(bizCurrencyTransformer(getKrkgkValue()))
            .orNull();
    }

    transient private String krkgkType = null;

    @Column(name=KRKGK + "$", nullable=true)
    protected String getKrkgkType() {
        if (krkgkType == null && krkgk != null) return krkgk.getType().toString();
        if (krkgkType == null && getKrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'krkgk$' should not be NULL."));
        }
        return krkgkType;
    }

    protected void setKrkgkType(String type) {
        krkgkType = type;
        krkgk = Optional.fromNullable(toCurrencyType(krkgkType))
            .transform(bizCurrencyTransformer(getKrkgkValue()))
            .orNull();
    }

    private BizDate lastsyosaihkymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.LASTSYOSAIHKYMD)
    public BizDate getLastsyosaihkymd() {
        return lastsyosaihkymd;
    }

    @Trim("both")
    public void setLastsyosaihkymd(BizDate pLastsyosaihkymd) {
        lastsyosaihkymd = pLastsyosaihkymd;
    }

    private BizDate lastmeihenymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.LASTMEIHENYMD)
    public BizDate getLastmeihenymd() {
        return lastmeihenymd;
    }

    @Trim("both")
    public void setLastmeihenymd(BizDate pLastmeihenymd) {
        lastmeihenymd = pLastmeihenymd;
    }

    private BizDate lastsbukthenymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.LASTSBUKTHENYMD)
    public BizDate getLastsbukthenymd() {
        return lastsbukthenymd;
    }

    public void setLastsbukthenymd(BizDate pLastsbukthenymd) {
        lastsbukthenymd = pLastsbukthenymd;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn1;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenJT_SiKykKihon.TTDKTYUUIKBN1)
    public C_TtdktyuuiKbn getTtdktyuuikbn1() {
        return ttdktyuuikbn1;
    }

    public void setTtdktyuuikbn1(C_TtdktyuuiKbn pTtdktyuuikbn1) {
        ttdktyuuikbn1 = pTtdktyuuikbn1;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn2;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenJT_SiKykKihon.TTDKTYUUIKBN2)
    public C_TtdktyuuiKbn getTtdktyuuikbn2() {
        return ttdktyuuikbn2;
    }

    public void setTtdktyuuikbn2(C_TtdktyuuiKbn pTtdktyuuikbn2) {
        ttdktyuuikbn2 = pTtdktyuuikbn2;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn3;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenJT_SiKykKihon.TTDKTYUUIKBN3)
    public C_TtdktyuuiKbn getTtdktyuuikbn3() {
        return ttdktyuuikbn3;
    }

    public void setTtdktyuuikbn3(C_TtdktyuuiKbn pTtdktyuuikbn3) {
        ttdktyuuikbn3 = pTtdktyuuikbn3;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn4;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenJT_SiKykKihon.TTDKTYUUIKBN4)
    public C_TtdktyuuiKbn getTtdktyuuikbn4() {
        return ttdktyuuikbn4;
    }

    public void setTtdktyuuikbn4(C_TtdktyuuiKbn pTtdktyuuikbn4) {
        ttdktyuuikbn4 = pTtdktyuuikbn4;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn5;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenJT_SiKykKihon.TTDKTYUUIKBN5)
    public C_TtdktyuuiKbn getTtdktyuuikbn5() {
        return ttdktyuuikbn5;
    }

    public void setTtdktyuuikbn5(C_TtdktyuuiKbn pTtdktyuuikbn5) {
        ttdktyuuikbn5 = pTtdktyuuikbn5;
    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiKykKihon.INITSBJIYENSITIHSYTKHUKAUMU)
    public C_UmuKbn getInitsbjiyensitihsytkhukaumu() {
        return initsbjiyensitihsytkhukaumu;
    }

    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn pInitsbjiyensitihsytkhukaumu) {
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaumu;
    }

    private BizCurrency initsbjiyenkasaiteihsygk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getInitsbjiyenkasaiteihsygk() {
        return initsbjiyenkasaiteihsygk;
    }

    public void setInitsbjiyenkasaiteihsygk(BizCurrency pInitsbjiyenkasaiteihsygk) {
        initsbjiyenkasaiteihsygk = pInitsbjiyenkasaiteihsygk;
        initsbjiyenkasaiteihsygkValue = null;
        initsbjiyenkasaiteihsygkType  = null;
    }

    transient private BigDecimal initsbjiyenkasaiteihsygkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=INITSBJIYENKASAITEIHSYGK, nullable=true)
    protected BigDecimal getInitsbjiyenkasaiteihsygkValue() {
        if (initsbjiyenkasaiteihsygkValue == null && initsbjiyenkasaiteihsygk != null) {
            if (initsbjiyenkasaiteihsygk.isOptional()) return null;
            return initsbjiyenkasaiteihsygk.absolute();
        }
        return initsbjiyenkasaiteihsygkValue;
    }

    protected void setInitsbjiyenkasaiteihsygkValue(BigDecimal value) {
        initsbjiyenkasaiteihsygkValue = value;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    transient private String initsbjiyenkasaiteihsygkType = null;

    @Column(name=INITSBJIYENKASAITEIHSYGK + "$", nullable=true)
    protected String getInitsbjiyenkasaiteihsygkType() {
        if (initsbjiyenkasaiteihsygkType == null && initsbjiyenkasaiteihsygk != null) return initsbjiyenkasaiteihsygk.getType().toString();
        if (initsbjiyenkasaiteihsygkType == null && getInitsbjiyenkasaiteihsygkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'initsbjiyenkasaiteihsygk$' should not be NULL."));
        }
        return initsbjiyenkasaiteihsygkType;
    }

    protected void setInitsbjiyenkasaiteihsygkType(String type) {
        initsbjiyenkasaiteihsygkType = type;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    private BizDate fstpnyknymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.FSTPNYKNYMD)
    public BizDate getFstpnyknymd() {
        return fstpnyknymd;
    }

    public void setFstpnyknymd(BizDate pFstpnyknymd) {
        fstpnyknymd = pFstpnyknymd;
    }

    private BizDate zennouryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykKihon.ZENNOURYOSYUYMD)
    public BizDate getZennouryosyuymd() {
        return zennouryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZennouryosyuymd(BizDate pZennouryosyuymd) {
        zennouryosyuymd = pZennouryosyuymd;
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenJT_SiKykKihon.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenJT_SiKykKihon.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private String kossyoricd;

    @Column(name=GenJT_SiKykKihon.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SiKykKihon.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiKykKihon.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiKykKihon.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}