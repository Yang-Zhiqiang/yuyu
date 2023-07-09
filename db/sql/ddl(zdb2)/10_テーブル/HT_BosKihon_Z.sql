CREATE TABLE HT_BosKihon_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     aitemosno                                          VARCHAR     (20)                                                                ,  /* 相手申込番号 */
     doujikaiyakusyono                                  VARCHAR     (20)                                                                ,  /* 同時解約証券番号 */
     sekno                                              VARCHAR     (20)                                                                ,  /* 設計書番号 */
     mosuketukekbn                                      VARCHAR     (1)                                                                 ,  /* 申込受付区分 */
     mosymd                                             VARCHAR     (8)                                                                 ,  /* 申込日 */
     mossakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 申込書作成日 */
     pplessmosukeymd                                    VARCHAR     (8)                                                                 ,  /* ペーパーレス申込書受付日 */
     pykkigenymd                                        VARCHAR     (8)                                                                 ,  /* 保険料有効期限年月日 */
     kktymd                                             VARCHAR     (8)                                                                 ,  /* 告知日 */
     moscalckijyunymd                                   VARCHAR     (8)                                                                 ,  /* 申込書計算基準日 */
     kykymdtkrumu                                       VARCHAR     (1)                                                                 ,  /* 契約日特例有無 */
     skykymd                                            VARCHAR     (8)                                                                 ,  /* 指定契約日 */
     kykkbn                                             VARCHAR     (2)                                                                 ,  /* 契約者区分 */
     hhknnmkn                                           VARCHAR     (38)                                                                ,  /* 被保険者名（カナ） */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     hhknnmkjkhukakbn                                   VARCHAR     (1)                                                                 ,  /* 被保険者名漢字化不可区分 */
     hhknseiymd                                         VARCHAR     (8)                                                                 ,  /* 被保険者生年月日 */
     hhknnen                                            DECIMAL     (3)                                                                 ,  /* 被保険者年齢 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     hhknsykgycd                                        VARCHAR     (3)                                                                 ,  /* 被保険者職業コード */
     hhknnensyuukbn                                     VARCHAR     (2)                                                                 ,  /* 被保険者年収区分 */
     tsindousiteikbn                                    VARCHAR     (1)                                                                 ,  /* 通信先同一指定区分 */
     hhknyno                                            VARCHAR     (7)                                                                 ,  /* 被保険者郵便番号 */
     hhknadr1kj                                         VARCHAR     (62)                                                                ,  /* 被保険者住所１（漢字） */
     hhknadr2kj                                         VARCHAR     (62)                                                                ,  /* 被保険者住所２（漢字） */
     hhknadr3kj                                         VARCHAR     (62)                                                                ,  /* 被保険者住所３（漢字） */
     hhkntelno                                          VARCHAR     (14)                                                                ,  /* 被保険者電話番号 */
     hhknkinmusakinm                                    VARCHAR     (102)                                                               ,  /* 被保険者勤務先名 */
     kyknmkn                                            VARCHAR     (38)                                                                ,  /* 契約者名（カナ） */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     kyknmkjkhukakbn                                    VARCHAR     (1)                                                                 ,  /* 契約者名漢字化不可区分 */
     kykseiymd                                          VARCHAR     (8)                                                                 ,  /* 契約者生年月日 */
     kyknen                                             DECIMAL     (3)                                                                 ,  /* 契約者年齢 */
     kyksei                                             VARCHAR     (1)                                                                 ,  /* 契約者性別 */
     kyktdk                                             VARCHAR     (2)                                                                 ,  /* 契約者続柄 */
     kyknensyuukbn                                      VARCHAR     (2)                                                                 ,  /* 契約者年収区分 */
     kykkinmusakinm                                     VARCHAR     (102)                                                               ,  /* 契約者勤務先名 */
     hjndaiykkbn                                        VARCHAR     (2)                                                                 ,  /* 法人代表者役職区分 */
     hjndainmkn                                         VARCHAR     (62)                                                                ,  /* 法人代表者名（カナ） */
     hjndainmkj                                         VARCHAR     (62)                                                                ,  /* 法人代表者名（漢字） */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（漢字） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     dai2tsintelno                                      VARCHAR     (14)                                                                ,  /* 第２通信先電話番号 */
     fatcasnsikbn                                       VARCHAR     (1)                                                                 ,  /* ＦＡＴＣＡ宣誓区分 */
     bikkjnssinfokbn                                    VARCHAR     (1)                                                                 ,  /* 米国人示唆情報区分 */
     aeoisnsikbn                                        VARCHAR     (1)                                                                 ,  /* ＡＥＯＩ宣誓区分 */
     hknsyuruino                                        VARCHAR     (3)                                                                 ,  /* 保険種類番号 */
     hknsyuruinosd                                      DECIMAL     (3)                                                                 ,  /* 保険種類番号世代 */
     nkgnshosyouritukbn                                 VARCHAR     (3)                                                                 ,  /* 年金原資最低保証率区分 */
     livhukaumu                                         VARCHAR     (1)                                                                 ,  /* リビングニーズ付加有無 */
     pmnjtkhukakbn                                      VARCHAR     (1)                                                                 ,  /* 保険料免除特約付加区分 */
     pmnjtkkbn                                          VARCHAR     (1)                                                                 ,  /* 保険料免除特約区分 */
     stdrsktkyhkkbn                                     VARCHAR     (1)                                                                 ,  /* 被保険者代理特約付加区分 */
     sdpdkbn                                            VARCHAR     (1)                                                                 ,  /* Ｓ建Ｐ建区分 */
     sntkhoukbn                                         VARCHAR     (2)                                                                 ,  /* 選択方法区分 */
     haitoukbn                                          VARCHAR     (2)                                                                 ,  /* 配当区分 */
     haitoukinuketorihoukbn                             VARCHAR     (1)                                                                 ,  /* 配当金受取方法区分 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     hrktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 払込通貨種類 */
     yennykntkhkkbn                                     VARCHAR     (1)                                                                 ,  /* 円入金特約付加区分 */
     gaikanykntkhkkbn                                   VARCHAR     (1)                                                                 ,  /* 外貨入金特約付加区分 */
     yenshrtkhkkbn                                      VARCHAR     (1)                                                                 ,  /* 円支払特約付加区分 */
     syutkpkei                                          DECIMAL     (13)                                                                ,  /* 主契約・特約Ｐ合計金額 */
     syutkpkei$                                         VARCHAR     (10)                                                                ,  /* 主契約・特約Ｐ合計金額(通貨型) */
     fsthrkpkei                                         DECIMAL     (13)                                                                ,  /* 初回払込Ｐ合計金額 */
     fsthrkpkei$                                        VARCHAR     (10)                                                                ,  /* 初回払込Ｐ合計金額(通貨型) */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     fstphrkkeirokbn                                    VARCHAR     (2)                                                                 ,  /* 初回保険料払込経路区分 */
     znnkai                                             DECIMAL     (3)                                                                 ,  /* 前納回数 */
     targettkhkkbn                                      VARCHAR     (1)                                                                 ,  /* ターゲット特約付加区分 */
     targettkkbn                                        VARCHAR     (1)                                                                 ,  /* ターゲット特約区分 */
     targettkmkhtkbn                                    VARCHAR     (3)                                                                 ,  /* ターゲット特約目標値区分 */
     nstkhkkbn                                          VARCHAR     (1)                                                                 ,  /* 年金支払特約付加区分 */
     nstkmnknsyu                                        DECIMAL     (2)                                                                 ,  /* 年金支払特約満期年金種類 */
     nstkmnknkkn                                        DECIMAL     (2)                                                                 ,  /* 年金支払特約満期年金期間 */
     nstksbnsyu                                         VARCHAR     (1)                                                                 ,  /* 年金支払特約死亡年金種類 */
     nstksbnkkn                                         DECIMAL     (2)                                                                 ,  /* 年金支払特約死亡年金期間 */
     syksbyensitihsyutkhkkbn                            VARCHAR     (1)                                                                 ,  /* 初期死亡時円換算最低保証特約付加区分 */
     jyudkaigomehrtkhkkbn                               VARCHAR     (1)                                                                 ,  /* 重度介護前払特約付加区分 */
     sbuktnin                                           DECIMAL     (2)                                                                 ,  /* 死亡受取人人数 */
     kykhonninkakninsyoruikbn                           VARCHAR     (2)                                                                 ,  /* 契約者本人確認書類区分 */
     skskknhonninkakninsyoruikbn                        VARCHAR     (2)                                                                 ,  /* 親権者後見人本人確認書類区分 */
     uktkid                                             VARCHAR     (11)                                                                ,  /* 受付管理ＩＤ */
     drctservicemoskbn                                  VARCHAR     (1)                                                                 ,  /* ダイレクトサービス申込区分 */
     dsmailaddress                                      VARCHAR     (100)                                                               ,  /* ＤＳメールアドレス */
     hnsstjmmouumukbn                                   VARCHAR     (1)                                                                 ,  /* 本社集中事務申込有無区分 */
     kjmeigihkhunouumukbn                               VARCHAR     (1)                                                                 ,  /* 漢字名義変換不能有無区分 */
     tsryhshrkykumukbn                                  VARCHAR     (1)                                                                 ,  /* 手数料不支払契約有無区分 */
     syosisyatodokeumukbn                               VARCHAR     (1)                                                                 ,  /* 証券支社届有無区分 */
     kakukisyouryakukbumukbn                            VARCHAR     (1)                                                                 ,  /* カク基省略希望有無区分 */
     seiymdmosseitouumukbn                              VARCHAR     (1)                                                                 ,  /* 生年月日申込書正当有無区分 */
     ikokakninsyotokkijkumu                             VARCHAR     (1)                                                                 ,  /* 意向確認書特記事項有無 */
     trtkhoukokusyotokkijkumu                           VARCHAR     (1)                                                                 ,  /* 取扱報告書特記事項有無 */
     hnnkakninhskjikouumukbn                            VARCHAR     (1)                                                                 ,  /* 本人確認補足事項有無 */
     hnnkakninhsktkjikouumukbn                          VARCHAR     (1)                                                                 ,  /* 本人確認補足特定事項有無 */
     skskakninhsktkjikouumukbn                          VARCHAR     (1)                                                                 ,  /* 親権者確認補足特定事項有無 */
     khnchkcmnt                                         VARCHAR     (838)                                                               ,  /* 基本チェックコメント */
     mostourokujyoukyoukbn                              VARCHAR     (1)                                                                 ,  /* 申込情報登録状況区分 */
     pplessdatasousinumukbn                             VARCHAR     (1)                                                                 ,  /* ペーパーレスデータ送信有無区分 */
     mobilebosyuukbn                                    VARCHAR     (1)                                                                 ,  /* モバイル募集区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     teirituhaibunwarikbn                               VARCHAR     (3)                                                                 ,  /* 定率部分配分割合区分 */
     sisuukbn                                           VARCHAR     (2)                                                                 ,  /* 指数区分 */
     sisuuhaibunwarikbn                                 VARCHAR     (3)                                                                 ,  /* 指数部分配分割合区分 */
     trhkjikakkbn                                       VARCHAR     (1)                                                                 ,  /* 取引時確認区分 */
     koureitaioukbn                                     VARCHAR     (3)                                                                 ,  /* 高齢者対応区分 */
     tokuteitrhkansyono                                 VARCHAR     (24)                                                                ,  /* 特定取引用暗証番号 */
     pplessrenjidssymenttdkhyj                          VARCHAR     (1)                                                                 ,  /* ペーパーレス連動時ＤＳ書面手続表示 */
     zennoumousideumu                                   VARCHAR     (1)                                                                 ,  /* 前納申出有無 */
     zenkizennouumu                                     VARCHAR     (1)                                                                 ,  /* 全期前納有無 */
     kjnnkpzeitekitkhukakbn                             VARCHAR     (1)                                                                 ,  /* 個人年金保険料税制適格特約付加区分 */
     pplsrendoukouhurikousoukbn                         VARCHAR     (1)                                                                 ,  /* ペーパーレス連動時口振申込書後送区分 */
     mosheijyunp                                        DECIMAL     (13)                                                                ,  /* 申込平準払Ｐ */
     mosheijyunp$                                       VARCHAR     (10)                                                                ,  /* 申込平準払Ｐ(通貨型) */
     ikkatubaraikbn                                     VARCHAR     (1)                                                                 ,  /* 一括払区分 */
     ikkatubaraikaisuu                                  VARCHAR     (2)                                                                 ,  /* 一括払回数 */
     mosikkatup                                         DECIMAL     (13)                                                                ,  /* 申込一括払Ｐ */
     mosikkatup$                                        VARCHAR     (10)                                                                ,  /* 申込一括払Ｐ(通貨型) */
     moszennoupsyokaiari                                DECIMAL     (13)                                                                ,  /* 申込前納Ｐ（初回含） */
     moszennoupsyokaiari$                               VARCHAR     (10)                                                                ,  /* 申込前納Ｐ（初回含）(通貨型) */
     yakkanjyuryouhoukbn                                VARCHAR     (1)                                                                 ,  /* 約款受領方法区分 */
     yakkanbunsyono                                     VARCHAR     (16)                                                                ,  /* 約款文書番号 */
     kzktourokuservicetourokukbn                        VARCHAR     (1)                                                                 ,  /* ご家族登録サービス登録区分 */
     kykdrtkykhukakbn                                   VARCHAR     (1)                                                                 ,  /* 契約者代理特約付加区分 */
     pplessrendoucreditkousoukbn                        VARCHAR     (1)                                                                 ,  /* ペーパーレス連動時クレカ申込書後送区分 */
     teikisiharaitkykhkkbn                              VARCHAR     (1)                                                                 ,  /* 定期支払特約付加区分 */
     koureikzksetumeihoukbn                             VARCHAR     (1)                                                                 ,  /* 高齢者ご家族等説明方法区分 */
     koureimndnhukusuukaikbn                            VARCHAR     (1)                                                                 ,  /* 高齢者面談複数回実施区分 */
     koureitratkisyaigidskkbn                           VARCHAR     (1)                                                                 ,  /* 高齢者取扱者以外同席区分 */
     daihituumukbn                                      VARCHAR     (1)                                                                    /* 代筆有無区分 */
)
;

ALTER TABLE HT_BosKihon_Z ADD CONSTRAINT PK_BosKihon PRIMARY KEY (
     mosno                                                      /* 申込番号 */
) ;

CREATE INDEX IX1_BosKihon ON HT_BosKihon_Z (
     mosuketukekbn                                            , /* 申込受付区分 */
     mostourokujyoukyoukbn                                      /* 申込情報登録状況区分 */
) ;
