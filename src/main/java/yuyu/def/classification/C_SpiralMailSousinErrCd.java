
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＳＰＩＲＡＬメール送信エラーコード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SpiralMailSousinErrCd</td><td colspan="3">ＳＰＩＲＡＬメール送信エラーコード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="98">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MAILERRORCODE_410}</td><td>&quot;4.1.0&quot;</td><td>アドレスに関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_411}</td><td>&quot;4.1.1&quot;</td><td>メールボックスが存在しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_412}</td><td>&quot;4.1.2&quot;</td><td>ドメインが存在しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_413}</td><td>&quot;4.1.3&quot;</td><td>アドレスが文法的に不正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_414}</td><td>&quot;4.1.4&quot;</td><td>アドレスの宛先が一意に決められない。（複数の受取人にマッチした）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_415}</td><td>&quot;4.1.5&quot;</td><td>アドレスは有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_416}</td><td>&quot;4.1.6&quot;</td><td>メールボックスが移動されたが、転送先の指定はない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_417}</td><td>&quot;4.1.7&quot;</td><td>差出人のアドレスが文法的に不正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_418}</td><td>&quot;4.1.8&quot;</td><td>return pathのアドレスが不正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_420}</td><td>&quot;4.2.0&quot;</td><td>メールボックスに関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_421}</td><td>&quot;4.2.1&quot;</td><td>メールボックスは存在するが、無効化されている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_422}</td><td>&quot;4.2.2&quot;</td><td>メールボックスのディスク容量制限を越えている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_423}</td><td>&quot;4.2.3&quot;</td><td>メッセージの長さがシステム管理上の限界を超えている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_424}</td><td>&quot;4.2.4&quot;</td><td>メーリングリスト展開時の問題</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_429}</td><td>&quot;4.2.9&quot;</td><td>受信側の制御等により受信を拒否された（パイプドビッツ独自拡張エラーコード）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_430}</td><td>&quot;4.3.0&quot;</td><td>メールシステムに関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_431}</td><td>&quot;4.3.1&quot;</td><td>メールシステムの能力を超えている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_432}</td><td>&quot;4.3.2&quot;</td><td>高負荷、メンテナンス等の理由に拠ってメールを受け付けられない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_433}</td><td>&quot;4.3.3&quot;</td><td>送信時に使用した機能を受取サーバーがサポートしていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_434}</td><td>&quot;4.3.4&quot;</td><td>1通あたりのメッセージサイズ制限を越えている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_435}</td><td>&quot;4.3.5&quot;</td><td>このメッセージを受け取れるように正しく設定されていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_440}</td><td>&quot;4.4.0&quot;</td><td>ネットワークに関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_441}</td><td>&quot;4.4.1&quot;</td><td>接続に対する応答がない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_442}</td><td>&quot;4.4.2&quot;</td><td>接続がタイムアウトし、配送を完了できなかった</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_443}</td><td>&quot;4.4.3&quot;</td><td>ディレクトリサーバー（DNSサーバー等）が動作していない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_444}</td><td>&quot;4.4.4&quot;</td><td>ディレクトリサーバー（DNSサーバー等）の動作が不良</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_445}</td><td>&quot;4.4.5&quot;</td><td>メールシステムが混雑していて、配送できない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_446}</td><td>&quot;4.4.6&quot;</td><td>配信ループが発生した</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_447}</td><td>&quot;4.4.7&quot;</td><td>メッセージが古すぎるため、受取が拒否された</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_450}</td><td>&quot;4.5.0&quot;</td><td>プロトコル実行に関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_451}</td><td>&quot;4.5.1&quot;</td><td>SMTPの発行順序もしくはサポートされていないコマンドを発行したことによるエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_452}</td><td>&quot;4.5.2&quot;</td><td>コマンドの文法的なエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_453}</td><td>&quot;4.5.3&quot;</td><td>プロトコルとして配送不可能な数の受取人が指定された</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_454}</td><td>&quot;4.5.4&quot;</td><td>コマンドの引数が理解できない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_455}</td><td>&quot;4.5.5&quot;</td><td>プロトコルのバージョンが合っていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_460}</td><td>&quot;4.6.0&quot;</td><td>コンテントもしくはメディアに関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_461}</td><td>&quot;4.6.1&quot;</td><td>メディアがサポートされていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_462}</td><td>&quot;4.6.2&quot;</td><td>必要なコンテントの変換が許可されていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_463}</td><td>&quot;4.6.3&quot;</td><td>必要なコンテントの変換を行うことができない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_464}</td><td>&quot;4.6.4&quot;</td><td>コンテントの変換により何らかのデータが失われた</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_465}</td><td>&quot;4.6.5&quot;</td><td>変換に失敗した</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_470}</td><td>&quot;4.7.0&quot;</td><td>セキュリティ、運用ポリシーに関する何らかの転送エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_471}</td><td>&quot;4.7.1&quot;</td><td>送信者による送信を拒否された</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_472}</td><td>&quot;4.7.2&quot;</td><td>指定されたメーリングリストに対する送信を拒否された</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_473}</td><td>&quot;4.7.3&quot;</td><td>必要なセキュリティ化プロトコルの変換が許可されていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_474}</td><td>&quot;4.7.4&quot;</td><td>必要なセキュリティ化機能がサポートされていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_475}</td><td>&quot;4.7.5&quot;</td><td>暗号の復号に必要なキーが存在しない、または誤っている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_476}</td><td>&quot;4.7.6&quot;</td><td>暗号の復号に必要なアルゴリズムがサポートされていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_477}</td><td>&quot;4.7.7&quot;</td><td>メッセージの改変により、復号に失敗した</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_510}</td><td>&quot;5.1.0&quot;</td><td>アドレスに関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_511}</td><td>&quot;5.1.1&quot;</td><td>メールボックスが存在しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_512}</td><td>&quot;5.1.2&quot;</td><td>ドメインが存在しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_513}</td><td>&quot;5.1.3&quot;</td><td>アドレスが文法的に不正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_514}</td><td>&quot;5.1.4&quot;</td><td>アドレスの宛先が一意に決められない。（複数の受取人にマッチした）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_515}</td><td>&quot;5.1.5&quot;</td><td>アドレスは有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_516}</td><td>&quot;5.1.6&quot;</td><td>メールボックスが移動されたが、転送先の指定はない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_517}</td><td>&quot;5.1.7&quot;</td><td>差出人のアドレスが文法的に不正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_518}</td><td>&quot;5.1.8&quot;</td><td>return pathのアドレスが不正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_520}</td><td>&quot;5.2.0&quot;</td><td>メールボックスに関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_521}</td><td>&quot;5.2.1&quot;</td><td>メールボックスは存在するが、無効化されている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_522}</td><td>&quot;5.2.2&quot;</td><td>メールボックスのディスク容量制限を越えている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_523}</td><td>&quot;5.2.3&quot;</td><td>メッセージの長さがシステム管理上の限界を超えている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_524}</td><td>&quot;5.2.4&quot;</td><td>メーリングリスト展開時の問題</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_529}</td><td>&quot;5.2.9&quot;</td><td>受信側の制御等により受信を拒否された（パイプドビッツ独自拡張エラーコード）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_530}</td><td>&quot;5.3.0&quot;</td><td>メールシステムに関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_531}</td><td>&quot;5.3.1&quot;</td><td>メールシステムの能力を超えている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_532}</td><td>&quot;5.3.2&quot;</td><td>高負荷、メンテナンス等の理由に拠ってメールを受け付けられない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_533}</td><td>&quot;5.3.3&quot;</td><td>送信時に使用した機能を受取サーバーがサポートしていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_534}</td><td>&quot;5.3.4&quot;</td><td>1通あたりのメッセージサイズ制限を越えている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_535}</td><td>&quot;5.3.5&quot;</td><td>このメッセージを受け取れるように正しく設定されていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_540}</td><td>&quot;5.4.0&quot;</td><td>ネットワークに関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_541}</td><td>&quot;5.4.1&quot;</td><td>接続に対する応答がない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_542}</td><td>&quot;5.4.2&quot;</td><td>接続がタイムアウトし、配送を完了できなかった</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_543}</td><td>&quot;5.4.3&quot;</td><td>ディレクトリサーバー（DNSサーバー等）が動作していない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_544}</td><td>&quot;5.4.4&quot;</td><td>ディレクトリサーバー（DNSサーバー等）の動作が不良</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_545}</td><td>&quot;5.4.5&quot;</td><td>メールシステムが混雑していて、配送できない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_546}</td><td>&quot;5.4.6&quot;</td><td>配信ループが発生した</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_547}</td><td>&quot;5.4.7&quot;</td><td>メッセージが古すぎるため、受取が拒否された</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_550}</td><td>&quot;5.5.0&quot;</td><td>プロトコル実行に関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_551}</td><td>&quot;5.5.1&quot;</td><td>SMTPの発行順序もしくはサポートされていないコマンドを発行したことによるエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_552}</td><td>&quot;5.5.2&quot;</td><td>コマンドの文法的なエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_553}</td><td>&quot;5.5.3&quot;</td><td>プロトコルとして配送不可能な数の受取人が指定された</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_554}</td><td>&quot;5.5.4&quot;</td><td>コマンドの引数が理解できない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_555}</td><td>&quot;5.5.5&quot;</td><td>プロトコルのバージョンが合っていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_560}</td><td>&quot;5.6.0&quot;</td><td>コンテントもしくはメディアに関する何らかのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_561}</td><td>&quot;5.6.1&quot;</td><td>メディアがサポートされていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_562}</td><td>&quot;5.6.2&quot;</td><td>必要なコンテントの変換が許可されていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_563}</td><td>&quot;5.6.3&quot;</td><td>必要なコンテントの変換を行うことができない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_564}</td><td>&quot;5.6.4&quot;</td><td>コンテントの変換により何らかのデータが失われた</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_565}</td><td>&quot;5.6.5&quot;</td><td>変換に失敗した</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_570}</td><td>&quot;5.7.0&quot;</td><td>セキュリティ、運用ポリシーに関する何らかの転送エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_571}</td><td>&quot;5.7.1&quot;</td><td>送信者による送信を拒否された</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_572}</td><td>&quot;5.7.2&quot;</td><td>指定されたメーリングリストに対する送信を拒否された</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_573}</td><td>&quot;5.7.3&quot;</td><td>必要なセキュリティ化プロトコルの変換が許可されていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_574}</td><td>&quot;5.7.4&quot;</td><td>必要なセキュリティ化機能がサポートされていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_575}</td><td>&quot;5.7.5&quot;</td><td>暗号の復号に必要なキーが存在しない、または誤っている</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_576}</td><td>&quot;5.7.6&quot;</td><td>暗号の復号に必要なアルゴリズムがサポートされていない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_577}</td><td>&quot;5.7.7&quot;</td><td>メッセージの改変により、復号に失敗した</td></tr>
 *  <tr><td rowspan="98">{@link #PATTERN_BUNRUIHENKAN BUNRUIHENKAN}<br />(分類変換)</td><td align="center">○</td><td>{@link #MAILERRORCODE_410}</td><td>&quot;4.1.0&quot;</td><td>ホスト不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_411}</td><td>&quot;4.1.1&quot;</td><td>ユーザ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_412}</td><td>&quot;4.1.2&quot;</td><td>ホスト不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_413}</td><td>&quot;4.1.3&quot;</td><td>ホスト不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_414}</td><td>&quot;4.1.4&quot;</td><td>ユーザ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_415}</td><td>&quot;4.1.5&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_416}</td><td>&quot;4.1.6&quot;</td><td>ユーザ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_417}</td><td>&quot;4.1.7&quot;</td><td>ホスト不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_418}</td><td>&quot;4.1.8&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_420}</td><td>&quot;4.2.0&quot;</td><td>サーバ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_421}</td><td>&quot;4.2.1&quot;</td><td>サーバ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_422}</td><td>&quot;4.2.2&quot;</td><td>ディスク容量不足</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_423}</td><td>&quot;4.2.3&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_424}</td><td>&quot;4.2.4&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_429}</td><td>&quot;4.2.9&quot;</td><td>受信拒否</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_430}</td><td>&quot;4.3.0&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_431}</td><td>&quot;4.3.1&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_432}</td><td>&quot;4.3.2&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_433}</td><td>&quot;4.3.3&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_434}</td><td>&quot;4.3.4&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_435}</td><td>&quot;4.3.5&quot;</td><td>サーバ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_440}</td><td>&quot;4.4.0&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_441}</td><td>&quot;4.4.1&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_442}</td><td>&quot;4.4.2&quot;</td><td>時間切れ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_443}</td><td>&quot;4.4.3&quot;</td><td>中継エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_444}</td><td>&quot;4.4.4&quot;</td><td>中継エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_445}</td><td>&quot;4.4.5&quot;</td><td>中継エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_446}</td><td>&quot;4.4.6&quot;</td><td>中継エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_447}</td><td>&quot;4.4.7&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_450}</td><td>&quot;4.5.0&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_451}</td><td>&quot;4.5.1&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_452}</td><td>&quot;4.5.2&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_453}</td><td>&quot;4.5.3&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_454}</td><td>&quot;4.5.4&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_455}</td><td>&quot;4.5.5&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_460}</td><td>&quot;4.6.0&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_461}</td><td>&quot;4.6.1&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_462}</td><td>&quot;4.6.2&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_463}</td><td>&quot;4.6.3&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_464}</td><td>&quot;4.6.4&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_465}</td><td>&quot;4.6.5&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_470}</td><td>&quot;4.7.0&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_471}</td><td>&quot;4.7.1&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_472}</td><td>&quot;4.7.2&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_473}</td><td>&quot;4.7.3&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_474}</td><td>&quot;4.7.4&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_475}</td><td>&quot;4.7.5&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_476}</td><td>&quot;4.7.6&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_477}</td><td>&quot;4.7.7&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_510}</td><td>&quot;5.1.0&quot;</td><td>ホスト不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_511}</td><td>&quot;5.1.1&quot;</td><td>ユーザ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_512}</td><td>&quot;5.1.2&quot;</td><td>ホスト不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_513}</td><td>&quot;5.1.3&quot;</td><td>ホスト不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_514}</td><td>&quot;5.1.4&quot;</td><td>ユーザ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_515}</td><td>&quot;5.1.5&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_516}</td><td>&quot;5.1.6&quot;</td><td>ユーザ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_517}</td><td>&quot;5.1.7&quot;</td><td>ホスト不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_518}</td><td>&quot;5.1.8&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_520}</td><td>&quot;5.2.0&quot;</td><td>サーバ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_521}</td><td>&quot;5.2.1&quot;</td><td>サーバ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_522}</td><td>&quot;5.2.2&quot;</td><td>ディスク容量不足</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_523}</td><td>&quot;5.2.3&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_524}</td><td>&quot;5.2.4&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_529}</td><td>&quot;5.2.9&quot;</td><td>受信拒否</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_530}</td><td>&quot;5.3.0&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_531}</td><td>&quot;5.3.1&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_532}</td><td>&quot;5.3.2&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_533}</td><td>&quot;5.3.3&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_534}</td><td>&quot;5.3.4&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_535}</td><td>&quot;5.3.5&quot;</td><td>サーバ設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_540}</td><td>&quot;5.4.0&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_541}</td><td>&quot;5.4.1&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_542}</td><td>&quot;5.4.2&quot;</td><td>時間切れ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_543}</td><td>&quot;5.4.3&quot;</td><td>中継エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_544}</td><td>&quot;5.4.4&quot;</td><td>中継エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_545}</td><td>&quot;5.4.5&quot;</td><td>中継エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_546}</td><td>&quot;5.4.6&quot;</td><td>中継エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_547}</td><td>&quot;5.4.7&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_550}</td><td>&quot;5.5.0&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_551}</td><td>&quot;5.5.1&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_552}</td><td>&quot;5.5.2&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_553}</td><td>&quot;5.5.3&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_554}</td><td>&quot;5.5.4&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_555}</td><td>&quot;5.5.5&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_560}</td><td>&quot;5.6.0&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_561}</td><td>&quot;5.6.1&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_562}</td><td>&quot;5.6.2&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_563}</td><td>&quot;5.6.3&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_564}</td><td>&quot;5.6.4&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_565}</td><td>&quot;5.6.5&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_570}</td><td>&quot;5.7.0&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_571}</td><td>&quot;5.7.1&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_572}</td><td>&quot;5.7.2&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_573}</td><td>&quot;5.7.3&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_574}</td><td>&quot;5.7.4&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_575}</td><td>&quot;5.7.5&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_576}</td><td>&quot;5.7.6&quot;</td><td>その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILERRORCODE_577}</td><td>&quot;5.7.7&quot;</td><td>その他エラー</td></tr>
 * </table>
 */
public class C_SpiralMailSousinErrCd extends Classification<C_SpiralMailSousinErrCd> {

    private static final long serialVersionUID = 1L;


    public static final C_SpiralMailSousinErrCd MAILERRORCODE_410 = new C_SpiralMailSousinErrCd("4.1.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_411 = new C_SpiralMailSousinErrCd("4.1.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_412 = new C_SpiralMailSousinErrCd("4.1.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_413 = new C_SpiralMailSousinErrCd("4.1.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_414 = new C_SpiralMailSousinErrCd("4.1.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_415 = new C_SpiralMailSousinErrCd("4.1.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_416 = new C_SpiralMailSousinErrCd("4.1.6");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_417 = new C_SpiralMailSousinErrCd("4.1.7");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_418 = new C_SpiralMailSousinErrCd("4.1.8");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_420 = new C_SpiralMailSousinErrCd("4.2.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_421 = new C_SpiralMailSousinErrCd("4.2.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_422 = new C_SpiralMailSousinErrCd("4.2.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_423 = new C_SpiralMailSousinErrCd("4.2.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_424 = new C_SpiralMailSousinErrCd("4.2.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_429 = new C_SpiralMailSousinErrCd("4.2.9");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_430 = new C_SpiralMailSousinErrCd("4.3.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_431 = new C_SpiralMailSousinErrCd("4.3.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_432 = new C_SpiralMailSousinErrCd("4.3.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_433 = new C_SpiralMailSousinErrCd("4.3.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_434 = new C_SpiralMailSousinErrCd("4.3.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_435 = new C_SpiralMailSousinErrCd("4.3.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_440 = new C_SpiralMailSousinErrCd("4.4.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_441 = new C_SpiralMailSousinErrCd("4.4.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_442 = new C_SpiralMailSousinErrCd("4.4.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_443 = new C_SpiralMailSousinErrCd("4.4.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_444 = new C_SpiralMailSousinErrCd("4.4.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_445 = new C_SpiralMailSousinErrCd("4.4.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_446 = new C_SpiralMailSousinErrCd("4.4.6");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_447 = new C_SpiralMailSousinErrCd("4.4.7");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_450 = new C_SpiralMailSousinErrCd("4.5.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_451 = new C_SpiralMailSousinErrCd("4.5.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_452 = new C_SpiralMailSousinErrCd("4.5.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_453 = new C_SpiralMailSousinErrCd("4.5.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_454 = new C_SpiralMailSousinErrCd("4.5.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_455 = new C_SpiralMailSousinErrCd("4.5.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_460 = new C_SpiralMailSousinErrCd("4.6.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_461 = new C_SpiralMailSousinErrCd("4.6.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_462 = new C_SpiralMailSousinErrCd("4.6.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_463 = new C_SpiralMailSousinErrCd("4.6.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_464 = new C_SpiralMailSousinErrCd("4.6.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_465 = new C_SpiralMailSousinErrCd("4.6.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_470 = new C_SpiralMailSousinErrCd("4.7.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_471 = new C_SpiralMailSousinErrCd("4.7.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_472 = new C_SpiralMailSousinErrCd("4.7.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_473 = new C_SpiralMailSousinErrCd("4.7.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_474 = new C_SpiralMailSousinErrCd("4.7.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_475 = new C_SpiralMailSousinErrCd("4.7.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_476 = new C_SpiralMailSousinErrCd("4.7.6");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_477 = new C_SpiralMailSousinErrCd("4.7.7");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_510 = new C_SpiralMailSousinErrCd("5.1.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_511 = new C_SpiralMailSousinErrCd("5.1.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_512 = new C_SpiralMailSousinErrCd("5.1.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_513 = new C_SpiralMailSousinErrCd("5.1.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_514 = new C_SpiralMailSousinErrCd("5.1.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_515 = new C_SpiralMailSousinErrCd("5.1.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_516 = new C_SpiralMailSousinErrCd("5.1.6");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_517 = new C_SpiralMailSousinErrCd("5.1.7");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_518 = new C_SpiralMailSousinErrCd("5.1.8");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_520 = new C_SpiralMailSousinErrCd("5.2.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_521 = new C_SpiralMailSousinErrCd("5.2.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_522 = new C_SpiralMailSousinErrCd("5.2.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_523 = new C_SpiralMailSousinErrCd("5.2.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_524 = new C_SpiralMailSousinErrCd("5.2.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_529 = new C_SpiralMailSousinErrCd("5.2.9");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_530 = new C_SpiralMailSousinErrCd("5.3.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_531 = new C_SpiralMailSousinErrCd("5.3.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_532 = new C_SpiralMailSousinErrCd("5.3.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_533 = new C_SpiralMailSousinErrCd("5.3.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_534 = new C_SpiralMailSousinErrCd("5.3.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_535 = new C_SpiralMailSousinErrCd("5.3.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_540 = new C_SpiralMailSousinErrCd("5.4.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_541 = new C_SpiralMailSousinErrCd("5.4.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_542 = new C_SpiralMailSousinErrCd("5.4.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_543 = new C_SpiralMailSousinErrCd("5.4.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_544 = new C_SpiralMailSousinErrCd("5.4.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_545 = new C_SpiralMailSousinErrCd("5.4.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_546 = new C_SpiralMailSousinErrCd("5.4.6");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_547 = new C_SpiralMailSousinErrCd("5.4.7");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_550 = new C_SpiralMailSousinErrCd("5.5.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_551 = new C_SpiralMailSousinErrCd("5.5.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_552 = new C_SpiralMailSousinErrCd("5.5.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_553 = new C_SpiralMailSousinErrCd("5.5.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_554 = new C_SpiralMailSousinErrCd("5.5.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_555 = new C_SpiralMailSousinErrCd("5.5.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_560 = new C_SpiralMailSousinErrCd("5.6.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_561 = new C_SpiralMailSousinErrCd("5.6.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_562 = new C_SpiralMailSousinErrCd("5.6.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_563 = new C_SpiralMailSousinErrCd("5.6.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_564 = new C_SpiralMailSousinErrCd("5.6.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_565 = new C_SpiralMailSousinErrCd("5.6.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_570 = new C_SpiralMailSousinErrCd("5.7.0");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_571 = new C_SpiralMailSousinErrCd("5.7.1");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_572 = new C_SpiralMailSousinErrCd("5.7.2");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_573 = new C_SpiralMailSousinErrCd("5.7.3");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_574 = new C_SpiralMailSousinErrCd("5.7.4");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_575 = new C_SpiralMailSousinErrCd("5.7.5");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_576 = new C_SpiralMailSousinErrCd("5.7.6");

    public static final C_SpiralMailSousinErrCd MAILERRORCODE_577 = new C_SpiralMailSousinErrCd("5.7.7");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_BUNRUIHENKAN = "2";


    static {

        addPattern(PATTERN_DEFAULT, MAILERRORCODE_410, "MAILERRORCODE_410", true);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_411, "MAILERRORCODE_411", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_412, "MAILERRORCODE_412", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_413, "MAILERRORCODE_413", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_414, "MAILERRORCODE_414", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_415, "MAILERRORCODE_415", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_416, "MAILERRORCODE_416", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_417, "MAILERRORCODE_417", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_418, "MAILERRORCODE_418", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_420, "MAILERRORCODE_420", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_421, "MAILERRORCODE_421", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_422, "MAILERRORCODE_422", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_423, "MAILERRORCODE_423", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_424, "MAILERRORCODE_424", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_429, "MAILERRORCODE_429", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_430, "MAILERRORCODE_430", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_431, "MAILERRORCODE_431", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_432, "MAILERRORCODE_432", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_433, "MAILERRORCODE_433", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_434, "MAILERRORCODE_434", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_435, "MAILERRORCODE_435", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_440, "MAILERRORCODE_440", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_441, "MAILERRORCODE_441", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_442, "MAILERRORCODE_442", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_443, "MAILERRORCODE_443", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_444, "MAILERRORCODE_444", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_445, "MAILERRORCODE_445", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_446, "MAILERRORCODE_446", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_447, "MAILERRORCODE_447", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_450, "MAILERRORCODE_450", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_451, "MAILERRORCODE_451", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_452, "MAILERRORCODE_452", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_453, "MAILERRORCODE_453", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_454, "MAILERRORCODE_454", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_455, "MAILERRORCODE_455", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_460, "MAILERRORCODE_460", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_461, "MAILERRORCODE_461", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_462, "MAILERRORCODE_462", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_463, "MAILERRORCODE_463", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_464, "MAILERRORCODE_464", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_465, "MAILERRORCODE_465", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_470, "MAILERRORCODE_470", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_471, "MAILERRORCODE_471", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_472, "MAILERRORCODE_472", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_473, "MAILERRORCODE_473", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_474, "MAILERRORCODE_474", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_475, "MAILERRORCODE_475", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_476, "MAILERRORCODE_476", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_477, "MAILERRORCODE_477", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_510, "MAILERRORCODE_510", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_511, "MAILERRORCODE_511", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_512, "MAILERRORCODE_512", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_513, "MAILERRORCODE_513", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_514, "MAILERRORCODE_514", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_515, "MAILERRORCODE_515", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_516, "MAILERRORCODE_516", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_517, "MAILERRORCODE_517", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_518, "MAILERRORCODE_518", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_520, "MAILERRORCODE_520", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_521, "MAILERRORCODE_521", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_522, "MAILERRORCODE_522", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_523, "MAILERRORCODE_523", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_524, "MAILERRORCODE_524", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_529, "MAILERRORCODE_529", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_530, "MAILERRORCODE_530", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_531, "MAILERRORCODE_531", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_532, "MAILERRORCODE_532", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_533, "MAILERRORCODE_533", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_534, "MAILERRORCODE_534", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_535, "MAILERRORCODE_535", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_540, "MAILERRORCODE_540", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_541, "MAILERRORCODE_541", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_542, "MAILERRORCODE_542", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_543, "MAILERRORCODE_543", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_544, "MAILERRORCODE_544", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_545, "MAILERRORCODE_545", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_546, "MAILERRORCODE_546", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_547, "MAILERRORCODE_547", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_550, "MAILERRORCODE_550", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_551, "MAILERRORCODE_551", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_552, "MAILERRORCODE_552", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_553, "MAILERRORCODE_553", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_554, "MAILERRORCODE_554", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_555, "MAILERRORCODE_555", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_560, "MAILERRORCODE_560", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_561, "MAILERRORCODE_561", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_562, "MAILERRORCODE_562", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_563, "MAILERRORCODE_563", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_564, "MAILERRORCODE_564", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_565, "MAILERRORCODE_565", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_570, "MAILERRORCODE_570", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_571, "MAILERRORCODE_571", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_572, "MAILERRORCODE_572", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_573, "MAILERRORCODE_573", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_574, "MAILERRORCODE_574", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_575, "MAILERRORCODE_575", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_576, "MAILERRORCODE_576", false);
        addPattern(PATTERN_DEFAULT, MAILERRORCODE_577, "MAILERRORCODE_577", false);


        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_410, "MAILERRORCODE_410", true);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_411, "MAILERRORCODE_411", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_412, "MAILERRORCODE_412", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_413, "MAILERRORCODE_413", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_414, "MAILERRORCODE_414", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_415, "MAILERRORCODE_415", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_416, "MAILERRORCODE_416", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_417, "MAILERRORCODE_417", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_418, "MAILERRORCODE_418", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_420, "MAILERRORCODE_420", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_421, "MAILERRORCODE_421", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_422, "MAILERRORCODE_422", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_423, "MAILERRORCODE_423", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_424, "MAILERRORCODE_424", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_429, "MAILERRORCODE_429", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_430, "MAILERRORCODE_430", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_431, "MAILERRORCODE_431", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_432, "MAILERRORCODE_432", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_433, "MAILERRORCODE_433", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_434, "MAILERRORCODE_434", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_435, "MAILERRORCODE_435", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_440, "MAILERRORCODE_440", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_441, "MAILERRORCODE_441", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_442, "MAILERRORCODE_442", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_443, "MAILERRORCODE_443", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_444, "MAILERRORCODE_444", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_445, "MAILERRORCODE_445", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_446, "MAILERRORCODE_446", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_447, "MAILERRORCODE_447", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_450, "MAILERRORCODE_450", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_451, "MAILERRORCODE_451", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_452, "MAILERRORCODE_452", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_453, "MAILERRORCODE_453", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_454, "MAILERRORCODE_454", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_455, "MAILERRORCODE_455", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_460, "MAILERRORCODE_460", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_461, "MAILERRORCODE_461", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_462, "MAILERRORCODE_462", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_463, "MAILERRORCODE_463", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_464, "MAILERRORCODE_464", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_465, "MAILERRORCODE_465", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_470, "MAILERRORCODE_470", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_471, "MAILERRORCODE_471", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_472, "MAILERRORCODE_472", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_473, "MAILERRORCODE_473", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_474, "MAILERRORCODE_474", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_475, "MAILERRORCODE_475", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_476, "MAILERRORCODE_476", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_477, "MAILERRORCODE_477", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_510, "MAILERRORCODE_510", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_511, "MAILERRORCODE_511", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_512, "MAILERRORCODE_512", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_513, "MAILERRORCODE_513", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_514, "MAILERRORCODE_514", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_515, "MAILERRORCODE_515", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_516, "MAILERRORCODE_516", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_517, "MAILERRORCODE_517", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_518, "MAILERRORCODE_518", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_520, "MAILERRORCODE_520", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_521, "MAILERRORCODE_521", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_522, "MAILERRORCODE_522", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_523, "MAILERRORCODE_523", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_524, "MAILERRORCODE_524", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_529, "MAILERRORCODE_529", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_530, "MAILERRORCODE_530", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_531, "MAILERRORCODE_531", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_532, "MAILERRORCODE_532", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_533, "MAILERRORCODE_533", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_534, "MAILERRORCODE_534", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_535, "MAILERRORCODE_535", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_540, "MAILERRORCODE_540", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_541, "MAILERRORCODE_541", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_542, "MAILERRORCODE_542", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_543, "MAILERRORCODE_543", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_544, "MAILERRORCODE_544", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_545, "MAILERRORCODE_545", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_546, "MAILERRORCODE_546", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_547, "MAILERRORCODE_547", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_550, "MAILERRORCODE_550", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_551, "MAILERRORCODE_551", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_552, "MAILERRORCODE_552", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_553, "MAILERRORCODE_553", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_554, "MAILERRORCODE_554", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_555, "MAILERRORCODE_555", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_560, "MAILERRORCODE_560", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_561, "MAILERRORCODE_561", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_562, "MAILERRORCODE_562", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_563, "MAILERRORCODE_563", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_564, "MAILERRORCODE_564", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_565, "MAILERRORCODE_565", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_570, "MAILERRORCODE_570", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_571, "MAILERRORCODE_571", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_572, "MAILERRORCODE_572", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_573, "MAILERRORCODE_573", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_574, "MAILERRORCODE_574", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_575, "MAILERRORCODE_575", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_576, "MAILERRORCODE_576", false);
        addPattern(PATTERN_BUNRUIHENKAN, MAILERRORCODE_577, "MAILERRORCODE_577", false);


        lock(C_SpiralMailSousinErrCd.class);
    }

    private C_SpiralMailSousinErrCd(String value) {
        super(value);
    }

    public static C_SpiralMailSousinErrCd valueOf(String value) {
        return valueOf(C_SpiralMailSousinErrCd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SpiralMailSousinErrCd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SpiralMailSousinErrCd.class, patternId, value);
    }
}
