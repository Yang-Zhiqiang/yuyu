CREATE TABLE HT_MosKihon (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     aitemosno                                          VARCHAR     (20)                                                                ,  /* 相手申込番号 */
     doujikaiyakusyono                                  VARCHAR     (20)                                                                ,  /* 同時解約証券番号 */
     sekno                                              VARCHAR     (20)                                                                ,  /* 設計書番号 */
     pykkigenymd                                        VARCHAR     (8)                                                                 ,  /* 保険料有効期限年月日 */
     mosymd                                             VARCHAR     (8)                                                                 ,  /* 申込日 */
     mossakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 申込書作成日 */
     moscalckijyunymd                                   VARCHAR     (8)                                                                 ,  /* 申込書計算基準日 */
     mosukeymd                                          VARCHAR     (8)                                                                 ,  /* 申込書受付日 */
     mosjimosuktymd                                     VARCHAR     (8)                                                                 ,  /* 申込時申込書受付日 */
     pplessmosukeymd                                    VARCHAR     (8)                                                                 ,  /* ペーパーレス申込書受付日 */
     mosym                                              VARCHAR     (6)                                                                 ,  /* 申込月度 */
     ssyukeymd                                          VARCHAR     (8)                                                                 ,  /* 支社受付日 */
     kktymd                                             VARCHAR     (8)                                                                 ,  /* 告知日 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     kykymdtkrumu                                       VARCHAR     (1)                                                                 ,  /* 契約日特例有無 */
     skykymd                                            VARCHAR     (8)                                                                 ,  /* 指定契約日 */
     sknnkaisiymd                                       VARCHAR     (8)                                                                 ,  /* 責任開始日 */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     seisekiym                                          VARCHAR     (6)                                                                 ,  /* 成績計上年月 */
     skeikeijyouym                                      VARCHAR     (6)                                                                 ,  /* 新契約計上年月 */
     kykkbn                                             VARCHAR     (2)                                                                 ,  /* 契約者区分 */
     hknsyuruino                                        VARCHAR     (3)                                                                 ,  /* 保険種類番号 */
     hknsyuruinosd                                      NUMBER      (3)                                                                 ,  /* 保険種類番号世代 */
     aisyoumeikbn                                       VARCHAR     (3)                                                                 ,  /* 愛称名区分 */
     nkgnshosyouritukbn                                 VARCHAR     (3)                                                                 ,  /* 年金原資最低保証率区分 */
     nkgnshosyougk                                      NUMBER      (13)                                                                ,  /* 年金原資最低保証額 */
     nkgnshosyougk$                                     VARCHAR     (10)                                                                ,  /* 年金原資最低保証額(通貨型) */
     livhukaumu                                         VARCHAR     (1)                                                                 ,  /* リビングニーズ付加有無 */
     pmnjtkhukakbn                                      VARCHAR     (1)                                                                 ,  /* 保険料免除特約付加区分 */
     pmnjtkkbn                                          VARCHAR     (1)                                                                 ,  /* 保険料免除特約区分 */
     sknnkaisikitkhukakbn                               VARCHAR     (1)                                                                 ,  /* 責任開始期特約付加区分 */
     sknnkaisikitkkbn                                   VARCHAR     (1)                                                                 ,  /* 責任開始期特約区分 */
     kzktourokuservicetourokukbn                        VARCHAR     (1)                                                                 ,  /* ご家族登録サービス登録区分 */
     kykdrtkykhukakbn                                   VARCHAR     (1)                                                                 ,  /* 契約者代理特約付加区分 */
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
     mosheijyunp                                        NUMBER      (13)                                                                ,  /* 申込平準払Ｐ */
     mosheijyunp$                                       VARCHAR     (10)                                                                ,  /* 申込平準払Ｐ(通貨型) */
     heijyunp                                           NUMBER      (13)                                                                ,  /* 平準払Ｐ */
     heijyunp$                                          VARCHAR     (10)                                                                ,  /* 平準払Ｐ(通貨型) */
     heijyunpryoumasinasi                               NUMBER      (13)                                                                ,  /* 平準払Ｐ（料増除） */
     heijyunpryoumasinasi$                              VARCHAR     (10)                                                                ,  /* 平準払Ｐ（料増除）(通貨型) */
     ikkatubaraikbn                                     VARCHAR     (1)                                                                 ,  /* 一括払区分 */
     ikkatubaraikaisuu                                  VARCHAR     (2)                                                                 ,  /* 一括払回数 */
     mosikkatup                                         NUMBER      (13)                                                                ,  /* 申込一括払Ｐ */
     mosikkatup$                                        VARCHAR     (10)                                                                ,  /* 申込一括払Ｐ(通貨型) */
     ikkatup                                            NUMBER      (13)                                                                ,  /* 一括払Ｐ */
     ikkatup$                                           VARCHAR     (10)                                                                ,  /* 一括払Ｐ(通貨型) */
     zennoumousideumu                                   VARCHAR     (1)                                                                 ,  /* 前納申出有無 */
     zenkizennouumu                                     VARCHAR     (1)                                                                 ,  /* 全期前納有無 */
     znnkai                                             NUMBER      (3)                                                                 ,  /* 前納回数 */
     moszennoupsyokaiari                                NUMBER      (13)                                                                ,  /* 申込前納Ｐ（初回含） */
     moszennoupsyokaiari$                               VARCHAR     (10)                                                                ,  /* 申込前納Ｐ（初回含）(通貨型) */
     zennoup                                            NUMBER      (13)                                                                ,  /* 前納Ｐ */
     zennoup$                                           VARCHAR     (10)                                                                ,  /* 前納Ｐ(通貨型) */
     zennoujyuutoup                                     NUMBER      (13)                                                                ,  /* 前納年払充当Ｐ */
     zennoujyuutoup$                                    VARCHAR     (10)                                                                ,  /* 前納年払充当Ｐ(通貨型) */
     znnhrkkai                                          VARCHAR     (2)                                                                 ,  /* 前納後払込回数 */
     znnhrkkeiro                                        VARCHAR     (2)                                                                 ,  /* 前納後払込経路 */
     mosfstpkei                                         NUMBER      (13)                                                                ,  /* 申込初回Ｐ合計金額 */
     mosfstpkei$                                        VARCHAR     (10)                                                                ,  /* 申込初回Ｐ合計金額(通貨型) */
     hyouteip                                           NUMBER      (13)                                                                ,  /* 表定Ｐ */
     hyouteip$                                          VARCHAR     (10)                                                                ,  /* 表定Ｐ(通貨型) */
     seitoufstpkei                                      NUMBER      (13)                                                                ,  /* 正当初回Ｐ合計金額 */
     seitoufstpkei$                                     VARCHAR     (10)                                                                ,  /* 正当初回Ｐ合計金額(通貨型) */
     fstphrkgk                                          NUMBER      (13)                                                                ,  /* 初回Ｐ払込必要額 */
     fstphrkgk$                                         VARCHAR     (10)                                                                ,  /* 初回Ｐ払込必要額(通貨型) */
     pharaikomisougaku                                  NUMBER      (13)                                                                ,  /* 保険料払込総額 */
     pharaikomisougaku$                                 VARCHAR     (10)                                                                ,  /* 保険料払込総額(通貨型) */
     sibouskei                                          NUMBER      (13)                                                                ,  /* 死亡Ｓ合計金額 */
     sibouskei$                                         VARCHAR     (10)                                                                ,  /* 死亡Ｓ合計金額(通貨型) */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     fstphrkkeirokbn                                    VARCHAR     (2)                                                                 ,  /* 初回保険料払込経路区分 */
     skjpjyuutoukaisuu                                  NUMBER      (2)                                                                 ,  /* 新契約時保険料充当回数 */
     ikkatuyoupumukbn                                   VARCHAR     (1)                                                                 ,  /* 一括要Ｐ有無区分 */
     ikkatuyoupkaisuu                                   NUMBER      (2)                                                                 ,  /* 一括要Ｐ回数 */
     pwaribikitekiyoukbn                                VARCHAR     (4)                                                                 ,  /* 保険料割引適用区分 */
     dntryouritukbn                                     VARCHAR     (1)                                                                 ,  /* 団体料率区分 */
     aplkahikbn                                         VARCHAR     (1)                                                                 ,  /* ＡＰＬ可否区分 */
     itipclriyoukbn                                     VARCHAR     (1)                                                                 ,  /* １ＰＣＬ利用区分 */
     itiprsymd                                          VARCHAR     (8)                                                                 ,  /* １Ｐ領収予定日 */
     dntcd                                              VARCHAR     (8)                                                                 ,  /* 団体コード */
     massiseiymd                                        VARCHAR     (8)                                                                 ,  /* 末子生年月日 */
     hhknnmkn                                           VARCHAR     (18)                                                                ,  /* 被保険者名（カナ） */
     hhknnmkj                                           VARCHAR     (15)                                                                ,  /* 被保険者名（漢字） */
     hhknnmkjkhukakbn                                   VARCHAR     (1)                                                                 ,  /* 被保険者名漢字化不可区分 */
     hhknseiymd                                         VARCHAR     (8)                                                                 ,  /* 被保険者生年月日 */
     hhknnen                                            NUMBER      (3)                                                                 ,  /* 被保険者年齢 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     hhknsykgycd                                        VARCHAR     (3)                                                                 ,  /* 被保険者職業コード */
     hhknnensyuukbn                                     VARCHAR     (2)                                                                 ,  /* 被保険者年収区分 */
     tsindousiteikbn                                    VARCHAR     (1)                                                                 ,  /* 通信先同一指定区分 */
     hhknyno                                            VARCHAR     (7)                                                                 ,  /* 被保険者郵便番号 */
     hhknadr1kn                                         VARCHAR     (30)                                                                ,  /* 被保険者住所１（カナ） */
     hhknadr2kn                                         VARCHAR     (30)                                                                ,  /* 被保険者住所２（カナ） */
     hhknadr3kn                                         VARCHAR     (30)                                                                ,  /* 被保険者住所３（カナ） */
     hhknadr1kj                                         VARCHAR     (30)                                                                ,  /* 被保険者住所１（漢字） */
     hhknadr2kj                                         VARCHAR     (30)                                                                ,  /* 被保険者住所２（漢字） */
     hhknadr3kj                                         VARCHAR     (30)                                                                ,  /* 被保険者住所３（漢字） */
     hhkntelno                                          VARCHAR     (14)                                                                ,  /* 被保険者電話番号 */
     hhknkinmusakinm                                    VARCHAR     (50)                                                                ,  /* 被保険者勤務先名 */
     kyknmkn                                            VARCHAR     (18)                                                                ,  /* 契約者名（カナ） */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     kyknmkjkhukakbn                                    VARCHAR     (1)                                                                 ,  /* 契約者名漢字化不可区分 */
     kykseiymd                                          VARCHAR     (8)                                                                 ,  /* 契約者生年月日 */
     kyknen                                             NUMBER      (3)                                                                 ,  /* 契約者年齢 */
     kyksei                                             VARCHAR     (1)                                                                 ,  /* 契約者性別 */
     kyktdk                                             VARCHAR     (2)                                                                 ,  /* 契約者続柄 */
     kyknensyuukbn                                      VARCHAR     (2)                                                                 ,  /* 契約者年収区分 */
     kykkinmusakinm                                     VARCHAR     (50)                                                                ,  /* 契約者勤務先名 */
     hjndaiykkbn                                        VARCHAR     (2)                                                                 ,  /* 法人代表者役職区分 */
     hjndainmkn                                         VARCHAR     (30)                                                                ,  /* 法人代表者名（カナ） */
     hjndainmkj                                         VARCHAR     (30)                                                                ,  /* 法人代表者名（漢字） */
     yakkanjyuryouhoukbn                                VARCHAR     (1)                                                                 ,  /* 約款受領方法区分 */
     yakkanbunsyono                                     VARCHAR     (16)                                                                ,  /* 約款文書番号 */
     siorino                                            VARCHAR     (3)                                                                 ,  /* しおり番号 */
     fatcasnsikbn                                       VARCHAR     (1)                                                                 ,  /* ＦＡＴＣＡ宣誓区分 */
     bikkjnssinfokbn                                    VARCHAR     (1)                                                                 ,  /* 米国人示唆情報区分 */
     bikknzsyno                                         VARCHAR     (9)                                                                 ,  /* 米国納税者番号 */
     syomeiymd                                          VARCHAR     (8)                                                                 ,  /* 署名日 */
     aeoisnsikbn                                        VARCHAR     (1)                                                                 ,  /* ＡＥＯＩ宣誓区分 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所３（漢字） */
     tsinadr1kn                                         VARCHAR     (30)                                                                ,  /* 通信先住所１（カナ） */
     tsinadr2kn                                         VARCHAR     (30)                                                                ,  /* 通信先住所２（カナ） */
     tsinadr3kn                                         VARCHAR     (30)                                                                ,  /* 通信先住所３（カナ） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     dai2tsintelno                                      VARCHAR     (14)                                                                ,  /* 第２通信先電話番号 */
     syoshadr1kj                                        VARCHAR     (30)                                                                ,  /* 証券送付先住所１（漢字） */
     syoshadr2kj                                        VARCHAR     (30)                                                                ,  /* 証券送付先住所２（漢字） */
     syoshadr3kj                                        VARCHAR     (30)                                                                ,  /* 証券送付先住所３（漢字） */
     syoshtelno                                         VARCHAR     (14)                                                                ,  /* 証券送付先電話番号 */
     syoshyno                                           VARCHAR     (7)                                                                 ,  /* 証券送付先郵便番号 */
     targettkhkkbn                                      VARCHAR     (1)                                                                 ,  /* ターゲット特約付加区分 */
     targettkkbn                                        VARCHAR     (1)                                                                 ,  /* ターゲット特約区分 */
     targettkmkhtkbn                                    VARCHAR     (3)                                                                 ,  /* ターゲット特約目標値区分 */
     nstkhkkbn                                          VARCHAR     (1)                                                                 ,  /* 年金支払特約付加区分 */
     nstkmnknsyu                                        NUMBER      (2)                                                                 ,  /* 年金支払特約満期年金種類 */
     nstkmnknkkn                                        NUMBER      (2)                                                                 ,  /* 年金支払特約満期年金期間 */
     nstksbnsyu                                         VARCHAR     (1)                                                                 ,  /* 年金支払特約死亡年金種類 */
     nstksbnkkn                                         NUMBER      (2)                                                                 ,  /* 年金支払特約死亡年金期間 */
     syksbyensitihsyutkhkkbn                            VARCHAR     (1)                                                                 ,  /* 初期死亡時円換算最低保証特約付加区分 */
     jyudkaigomehrtkhkkbn                               VARCHAR     (1)                                                                 ,  /* 重度介護前払特約付加区分 */
     kjnnkpzeitekitkhukakbn                             VARCHAR     (1)                                                                 ,  /* 個人年金保険料税制適格特約付加区分 */
     teikisiharaitkykhkkbn                              VARCHAR     (1)                                                                 ,  /* 定期支払特約付加区分 */
     saihocd                                            VARCHAR     (20)                                                                ,  /* 再保険会社コード */
     stknsetkbn                                         VARCHAR     (1)                                                                 ,  /* 質権設定区分 */
     sbuktnin                                           NUMBER      (2)                                                                 ,  /* 死亡受取人人数 */
     kykhonninkakninsyoruikbn                           VARCHAR     (2)                                                                 ,  /* 契約者本人確認書類区分 */
     skskknhonninkakninsyoruikbn                        VARCHAR     (2)                                                                 ,  /* 親権者後見人本人確認書類区分 */
     koureikzksetumeihoukbn                             VARCHAR     (1)                                                                 ,  /* 高齢者ご家族等説明方法区分 */
     koureimndnhukusuukaikbn                            VARCHAR     (1)                                                                 ,  /* 高齢者面談複数回実施区分 */
     koureitratkisyaigidskkbn                           VARCHAR     (1)                                                                 ,  /* 高齢者取扱者以外同席区分 */
     daihituumukbn                                      VARCHAR     (1)                                                                 ,  /* 代筆有無区分 */
     syotnshuyoupostumukbn                              VARCHAR     (1)                                                                 ,  /* 証券転送不要郵便有無区分 */
     uktkid                                             VARCHAR     (11)                                                                ,  /* 受付管理ＩＤ */
     boskykjyoutai                                      VARCHAR     (1)                                                                 ,  /* 募集契約状態 */
     tkkinyukkntkrumu                                   VARCHAR     (1)                                                                 ,  /* 地域金融機関特例有無 */
     drctservicemoskbn                                  VARCHAR     (1)                                                                 ,  /* ダイレクトサービス申込区分 */
     dskokno                                            VARCHAR     (10)                                                                ,  /* ＤＳ顧客番号 */
     dsmailaddress                                      VARCHAR     (100)                                                               ,  /* ＤＳメールアドレス */
     tokuteitrhkansyono                                 VARCHAR     (24)                                                                ,  /* 特定取引用暗証番号 */
     pplessrenjidssymenttdkhyj                          VARCHAR     (1)                                                                 ,  /* ペーパーレス連動時ＤＳ書面手続表示 */
     pplsrendoukouhurikousoukbn                         VARCHAR     (1)                                                                 ,  /* ペーパーレス連動時口振申込書後送区分 */
     pplessrendoucreditkousoukbn                        VARCHAR     (1)                                                                 ,  /* ペーパーレス連動時クレカ申込書後送区分 */
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
     kouseiinkyktkjkumukbn                              VARCHAR     (1)                                                                 ,  /* 構成員契約特記事項有無区分 */
     koukankykkinmusakinm                               VARCHAR     (35)                                                                ,  /* 交換契約勤務先名 */
     koukankyksyokumunaiyou                             VARCHAR     (35)                                                                ,  /* 交換契約職務内容 */
     koukankyktkjkumukbn                                VARCHAR     (1)                                                                 ,  /* 交換契約特記事項有無区分 */
     khnchkcmnt                                         VARCHAR     (418)                                                               ,  /* 基本チェックコメント */
     mobilebosyuukbn                                    VARCHAR     (1)                                                                 ,  /* モバイル募集区分 */
     jimuyoucd                                          VARCHAR     (3)                                                                 ,  /* 事務用コード */
     teirituhaibunwarikbn                               VARCHAR     (3)                                                                 ,  /* 定率部分配分割合区分 */
     sisuukbn                                           VARCHAR     (2)                                                                 ,  /* 指数区分 */
     sisuuhaibunwarikbn                                 VARCHAR     (3)                                                                 ,  /* 指数部分配分割合区分 */
     trhkjikakkbn                                       VARCHAR     (1)                                                                 ,  /* 取引時確認区分 */
     koureitaioukbn                                     VARCHAR     (3)                                                                 ,  /* 高齢者対応区分 */
     kyktuukasyu2                                       VARCHAR     (3)                                                                 ,  /* 契約通貨種類＿２ */
     hrktuukasyu2                                       VARCHAR     (3)                                                                 ,  /* 払込通貨種類＿２ */
     mosheijyunp2                                       NUMBER      (13)                                                                ,  /* 申込平準払Ｐ＿２ */
     mosheijyunp2$                                      VARCHAR     (10)                                                                ,  /* 申込平準払Ｐ＿２(通貨型) */
     mosikkatup2                                        NUMBER      (13)                                                                ,  /* 申込一括払Ｐ＿２ */
     mosikkatup2$                                       VARCHAR     (10)                                                                ,  /* 申込一括払Ｐ＿２(通貨型) */
     moszennoupsyokaiari2                               NUMBER      (13)                                                                ,  /* 申込前納Ｐ（初回含）＿２ */
     moszennoupsyokaiari2$                              VARCHAR     (10)                                                                ,  /* 申込前納Ｐ（初回含）＿２(通貨型) */
     kjnnkpzeitekitkhukakbn2                            VARCHAR     (1)                                                                 ,  /* 個人年金保険料税制適格特約付加区分＿２ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_MosKihon ADD CONSTRAINT PK_MosKihon PRIMARY KEY (
     mosno                                                      /* 申込番号 */
) ;

CREATE INDEX IX1_MosKihon ON HT_MosKihon (
     uktkid                                                     /* 受付管理ＩＤ */
) ;

CREATE INDEX IX2_MosKihon ON HT_MosKihon (
     mosymd                                                     /* 申込日 */
) ;

CREATE INDEX IX3_MosKihon ON HT_MosKihon (
     bosyuuym                                                   /* 募集年月 */
) ;

CREATE INDEX IX4_MosKihon ON HT_MosKihon (
     seisekiym                                                  /* 成績計上年月 */
) ;

CREATE INDEX IX5_MosKihon ON HT_MosKihon (
     skeikeijyouym                                              /* 新契約計上年月 */
) ;
