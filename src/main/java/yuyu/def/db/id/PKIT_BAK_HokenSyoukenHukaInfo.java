package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_BAK_HokenSyoukenHukaInfo;
import yuyu.def.db.mapping.GenIT_BAK_HokenSyoukenHukaInfo;
import yuyu.def.db.meta.GenQIT_BAK_HokenSyoukenHukaInfo;
import yuyu.def.db.meta.QIT_BAK_HokenSyoukenHukaInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険証券付加情報データバックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_HokenSyoukenHukaInfo}</td><td colspan="3">保険証券付加情報データバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nksyuruinmsyouken</td><td>年金種類名称（証券用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teikiikkatubaraitukisuu</td><td>定期一括払月数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>znntikiktbriyhrkgktuktype</td><td>前納定期一括払円貨払込額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>znntikiktbriyenhrkgk</td><td>前納定期一括払円貨払込額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>znnkai2</td><td>前納回数（２桁）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hutanhiyustmkyakkjrtmin</td><td>ご負担費用説明欄解約控除率最小</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hutanhiyustmkyakkjrtmax</td><td>ご負担費用説明欄解約控除率最大</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>fstpznnkngktuktype</td><td>初回Ｐご確認欄前納金額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>fstpznnkngk</td><td>初回Ｐご確認欄前納金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dskjnkngkktuktype</td><td>ＤＳ基準金額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dskjnkngk</td><td>ＤＳ基準金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tikiktbriyhrkgktuktype</td><td>定期一括払円貨払込額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>tikiktbriyenhrkgk</td><td>定期一括払円貨払込額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kzktirasidouhuukbn1</td><td>ご家族登録チラシ１同封区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kzktirasidouhuukbn2</td><td>ご家族登録チラシ２同封区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykdairitirasidouhuukbn</td><td>保険契約者代理人チラシ同封区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>skhtirasidouhuukbn</td><td>債権法チラシ同封区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>yakkannewoldkbn</td><td>約款新旧区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokuservicemsg1</td><td>ご家族登録サービスメッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokuservicemsg2</td><td>ご家族登録サービスメッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokuservicemsg3</td><td>ご家族登録サービスメッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokuservicemsg4</td><td>ご家族登録サービスメッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokuservicemsg5</td><td>ご家族登録サービスメッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokuservicemsg6</td><td>ご家族登録サービスメッセージコード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokuservicemsg7</td><td>ご家族登録サービスメッセージコード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokuservicemsg8</td><td>ご家族登録サービスメッセージコード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzknmkj118</td><td>登録家族名１（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzksei1</td><td>登録家族性別１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seibetu C_Seibetu}</td></tr>
 *  <tr><td>trkkzkseiymd1</td><td>登録家族生年月日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trkkzkyno1</td><td>登録家族郵便番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr1kj1</td><td>登録家族住所１（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr2kj1</td><td>登録家族住所２（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr3kj1</td><td>登録家族住所３（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktelno1</td><td>登録家族電話番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzksei2</td><td>登録家族性別２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seibetu C_Seibetu}</td></tr>
 *  <tr><td>trkkzknmkj218</td><td>登録家族名２（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkseiymd2</td><td>登録家族生年月日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trkkzkyno2</td><td>登録家族郵便番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr1kj2</td><td>登録家族住所１（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr2kj2</td><td>登録家族住所２（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr3kj2</td><td>登録家族住所３（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktelno2</td><td>登録家族電話番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairinm18</td><td>契約者代理人名（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkndairinm</td><td>被保険者代理人氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rendouritu</td><td>連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>teikisiharaikin</td><td>定期支払金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyentype</td><td>第１死亡時受取額（円貨）通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1zennouzndk01</td><td>第１前納残高０１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndktype01</td><td>第１前納残高通貨タイプ０１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgk01</td><td>第１死亡時受取額０１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgktype01</td><td>第１死亡時受取額通貨タイプ０１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgkyendaka01</td><td>第１死亡時受取額（円貨）（円高）０１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenkijyun01</td><td>第１死亡時受取額（円貨）（中央値）０１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenyasu01</td><td>第１死亡時受取額（円貨）（円安）０１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndk02</td><td>第１前納残高０２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndktype02</td><td>第１前納残高通貨タイプ０２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgk02</td><td>第１死亡時受取額０２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgktype02</td><td>第１死亡時受取額通貨タイプ０２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgkyendaka02</td><td>第１死亡時受取額（円貨）（円高）０２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenkijyun02</td><td>第１死亡時受取額（円貨）（中央値）０２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenyasu02</td><td>第１死亡時受取額（円貨）（円安）０２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndk03</td><td>第１前納残高０３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndktype03</td><td>第１前納残高通貨タイプ０３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgk03</td><td>第１死亡時受取額０３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgktype03</td><td>第１死亡時受取額通貨タイプ０３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgkyendaka03</td><td>第１死亡時受取額（円貨）（円高）０３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenkijyun03</td><td>第１死亡時受取額（円貨）（中央値）０３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenyasu03</td><td>第１死亡時受取額（円貨）（円安）０３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndk04</td><td>第１前納残高０４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndktype04</td><td>第１前納残高通貨タイプ０４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgk04</td><td>第１死亡時受取額０４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgktype04</td><td>第１死亡時受取額通貨タイプ０４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgkyendaka04</td><td>第１死亡時受取額（円貨）（円高）０４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenkijyun04</td><td>第１死亡時受取額（円貨）（中央値）０４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenyasu04</td><td>第１死亡時受取額（円貨）（円安）０４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndk05</td><td>第１前納残高０５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndktype05</td><td>第１前納残高通貨タイプ０５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgk05</td><td>第１死亡時受取額０５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgktype05</td><td>第１死亡時受取額通貨タイプ０５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgkyendaka05</td><td>第１死亡時受取額（円貨）（円高）０５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenkijyun05</td><td>第１死亡時受取額（円貨）（中央値）０５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenyasu05</td><td>第１死亡時受取額（円貨）（円安）０５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndk06</td><td>第１前納残高０６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1zennouzndktype06</td><td>第１前納残高通貨タイプ０６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgk06</td><td>第１死亡時受取額０６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgktype06</td><td>第１死亡時受取額通貨タイプ０６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1sbjiuktgkyendaka06</td><td>第１死亡時受取額（円貨）（円高）０６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenkijyun06</td><td>第１死亡時受取額（円貨）（中央値）０６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1sbjiuktgkyenyasu06</td><td>第１死亡時受取額（円貨）（円安）０６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkydaka01</td><td>介護前払受領額０１（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkydaka02</td><td>介護前払受領額０２（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkydaka03</td><td>介護前払受領額０３（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkydaka04</td><td>介護前払受領額０４（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkydaka05</td><td>介護前払受領額０５（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkydaka06</td><td>介護前払受領額０６（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkydaka07</td><td>介護前払受領額０７（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkydaka08</td><td>介護前払受領額０８（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkydaka09</td><td>介護前払受領額０９（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkydaka10</td><td>介護前払受領額１０（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkykijyun01</td><td>介護前払受領額０１（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkykijyun02</td><td>介護前払受領額０２（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkykijyun03</td><td>介護前払受領額０３（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkykijyun04</td><td>介護前払受領額０４（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkykijyun05</td><td>介護前払受領額０５（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkykijyun06</td><td>介護前払受領額０６（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkykijyun07</td><td>介護前払受領額０７（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkykijyun08</td><td>介護前払受領額０８（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkykijyun09</td><td>介護前払受領額０９（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkykijyun10</td><td>介護前払受領額１０（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkyyasu01</td><td>介護前払受領額０１（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkyyasu02</td><td>介護前払受領額０２（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkyyasu03</td><td>介護前払受領額０３（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkyyasu04</td><td>介護前払受領額０４（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkyyasu05</td><td>介護前払受領額０５（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkyyasu06</td><td>介護前払受領額０６（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkyyasu07</td><td>介護前払受領額０７（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkyyasu08</td><td>介護前払受領額０８（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkyyasu09</td><td>介護前払受領額０９（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrjrugkyyasu10</td><td>介護前払受領額１０（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_BAK_HokenSyoukenHukaInfo
 * @see     GenIT_BAK_HokenSyoukenHukaInfo
 * @see     QIT_BAK_HokenSyoukenHukaInfo
 * @see     GenQIT_BAK_HokenSyoukenHukaInfo
 */
public class PKIT_BAK_HokenSyoukenHukaInfo extends AbstractExDBPrimaryKey<IT_BAK_HokenSyoukenHukaInfo, PKIT_BAK_HokenSyoukenHukaInfo> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_HokenSyoukenHukaInfo() {
    }

    public PKIT_BAK_HokenSyoukenHukaInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDate pTyouhyouymd
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        tyouhyouymd = pTyouhyouymd;
    }

    @Transient
    @Override
    public Class<IT_BAK_HokenSyoukenHukaInfo> getEntityClass() {
        return IT_BAK_HokenSyoukenHukaInfo.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

}