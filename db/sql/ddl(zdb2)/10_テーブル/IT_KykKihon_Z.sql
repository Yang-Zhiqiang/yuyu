CREATE TABLE IT_KykKihon_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     aitesyono                                          VARCHAR     (20)                                                                ,  /* 相手証券番号 */
     haitoukbn                                          VARCHAR     (2)                                                                 ,  /* 配当区分 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     sdpdkbn                                            VARCHAR     (1)                                                                 ,  /* Ｓ建Ｐ建区分 */
     dntryouritukbn                                     VARCHAR     (1)                                                                 ,  /* 団体料率区分 */
     dntcd                                              VARCHAR     (8)                                                                 ,  /* 団体コード */
     sntkhoukbn                                         VARCHAR     (2)                                                                 ,  /* 選択方法区分 */
     sinsakbn                                           VARCHAR     (2)                                                                 ,  /* 診査区分 */
     mosymd                                             VARCHAR     (8)                                                                 ,  /* 申込日 */
     kktymd                                             VARCHAR     (8)                                                                 ,  /* 告知日 */
     fstpnyknymd                                        VARCHAR     (8)                                                                 ,  /* 初回保険料入金日 */
     mosukeymd                                          VARCHAR     (8)                                                                 ,  /* 申込書受付日 */
     mosjimosuktymd                                     VARCHAR     (8)                                                                 ,  /* 申込時申込書受付日 */
     seirituymd                                         VARCHAR     (8)                                                                 ,  /* 成立日 */
     itiprsymd                                          VARCHAR     (8)                                                                 ,  /* １Ｐ領収予定日 */
     hrkp                                               DECIMAL     (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     seisekiym                                          VARCHAR     (6)                                                                 ,  /* 成績計上年月 */
     skeikeijyouym                                      VARCHAR     (6)                                                                 ,  /* 新契約計上年月 */
     plancd                                             VARCHAR     (10)                                                                ,  /* プランコード */
     planrenno                                          DECIMAL     (2)                                                                 ,  /* プラン連番 */
     aisyoumeikbn                                       VARCHAR     (3)                                                                 ,  /* 愛称名区分 */
     syusaiumu                                          VARCHAR     (1)                                                                 ,  /* 出再有無 */
     stknsetkbn                                         VARCHAR     (1)                                                                 ,  /* 質権設定区分 */
     kykksykjyumu                                       VARCHAR     (1)                                                                 ,  /* 契約者貸付約定有無 */
     kykksumu                                           VARCHAR     (1)                                                                 ,  /* 契約者貸付有無 */
     aplkahikbn                                         VARCHAR     (1)                                                                 ,  /* ＡＰＬ可否区分 */
     aplumu                                             VARCHAR     (1)                                                                 ,  /* ＡＰＬ有無 */
     fstphrkkeirokbn                                    VARCHAR     (2)                                                                 ,  /* 初回保険料払込経路区分 */
     haitounendo                                        VARCHAR     (4)                                                                 ,  /* 配当年度 */
     haitoukinuketorihoukbn                             VARCHAR     (1)                                                                 ,  /* 配当金受取方法区分 */
     tratkityuiumu                                      VARCHAR     (1)                                                                 ,  /* 取扱注意有無 */
     tratkityuiuny                                      VARCHAR     (82)                                                                ,  /* 取扱注意内容 */
     sbuktnin                                           DECIMAL     (2)                                                                 ,  /* 死亡受取人人数 */
     gansindankakuteiymd                                VARCHAR     (32)                                                                ,  /* がん診断確定日 */
     mosuketukekbn                                      VARCHAR     (1)                                                                 ,  /* 申込受付区分 */
     kijikbn                                            VARCHAR     (1)                                                                 ,  /* 記事区分 */
     hhknsykgycd                                        VARCHAR     (3)                                                                 ,  /* 被保険者職業コード */
     hhknnensyuukbn                                     VARCHAR     (2)                                                                 ,  /* 被保険者年収区分 */
     drtenkanritodoufukencd                             VARCHAR     (2)                                                                 ,  /* 代理店管理都道府県コード */
     cifcd                                              VARCHAR     (15)                                                                ,  /* ＣＩＦコード */
     smbckanriid                                        VARCHAR     (11)                                                                ,  /* ＳＭＢＣ受付管理ＩＤ */
     tsryhshrkykumukbn                                  VARCHAR     (1)                                                                 ,  /* 手数料不支払契約有無区分 */
     kykhonninkakninsyoruikbn                           VARCHAR     (2)                                                                 ,  /* 契約者本人確認書類区分 */
     skskknhonninkakninsyoruikbn                        VARCHAR     (2)                                                                 ,  /* 親権者後見人本人確認書類区分 */
     boskykjyoutai                                      VARCHAR     (1)                                                                 ,  /* 募集契約状態 */
     kanyuusyano                                        DECIMAL     (12)                                                                ,  /* 加入者番号 */
     drctservicemoskbn                                  VARCHAR     (1)                                                                 ,  /* ダイレクトサービス申込区分 */
     sksyoukenskskbn                                    VARCHAR     (1)                                                                 ,  /* 新契約証券作成区分 */
     sinkyksyokensakuseiymd                             VARCHAR     (8)                                                                 ,  /* 新契約証券作成日 */
     syoyousinkyksyohakkouymd                           VARCHAR     (8)                                                                 ,  /* 証券用新契約証券発行日 */
     skjmosno                                           VARCHAR     (20)                                                                ,  /* 新契約時申込番号 */
     nkuikosumikbn                                      VARCHAR     (1)                                                                 ,  /* 年金移行済区分 */
     syhenkouymd                                        VARCHAR     (8)                                                                 ,  /* 最終変更日 */
     lastsyosaihkymd                                    VARCHAR     (8)                                                                 ,  /* 最終証券再発行日 */
     lastmeihenymd                                      VARCHAR     (8)                                                                 ,  /* 最終名義変更日 */
     lastkykmeighnkymd                                  VARCHAR     (8)                                                                 ,  /* 最終契約者名義変更日 */
     lastsbukthenymd                                    VARCHAR     (8)                                                                 ,  /* 最終死亡受取人変更日 */
     lastkyknmseiymdhenkouymd                           VARCHAR     (8)                                                                 ,  /* 最終契約者名生年月日変更日 */
     lastkyknmkanakjteiymd                              VARCHAR     (8)                                                                 ,  /* 最終契約者名仮名漢字訂正日 */
     lasttsinynohenkouymd                               VARCHAR     (8)                                                                 ,  /* 最終通信先郵便番号変更日 */
     lastjyuuhenymd                                     VARCHAR     (8)                                                                 ,  /* 最終住所変更日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     seiritujitrhkjikakkbn                              VARCHAR     (1)                                                                 ,  /* 成立時取引時確認区分 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     yakkanjyuryouhoukbn                                VARCHAR     (1)                                                                 ,  /* 約款受領方法区分 */
     yakkanbunsyono                                     VARCHAR     (16)                                                                ,  /* 約款文書番号 */
     siorino                                            VARCHAR     (3)                                                                 ,  /* しおり番号 */
     ynkhrkmgkannituutikbn                              VARCHAR     (1)                                                                    /* 円貨払込額案内通知区分 */
)
;

ALTER TABLE IT_KykKihon_Z ADD CONSTRAINT PK_KykKihon PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_KykKihon ON IT_KykKihon_Z (
     syono                                                      /* 証券番号 */
) ;
