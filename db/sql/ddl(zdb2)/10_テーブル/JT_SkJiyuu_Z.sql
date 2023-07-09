CREATE TABLE JT_SkJiyuu_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     seikyuurirekino                                    DECIMAL     (3)                                                       NOT NULL  ,  /* 請求履歴番号 */
     uketukeno                                          DECIMAL     (2)                                                       NOT NULL  ,  /* 受付番号 */
     geninkbn                                           VARCHAR     (2)                                                                 ,  /* 原因区分 */
     jikosyosinymd                                      VARCHAR     (8)                                                                 ,  /* 事故（初診）日 */
     syoubyouhsymd                                      VARCHAR     (8)                                                                 ,  /* 傷病発生日 */
     saigaigeninkbn                                     VARCHAR     (2)                                                                 ,  /* 災害原因区分 */
     gansindankakuteiymd                                VARCHAR     (32)                                                                ,  /* がん診断確定日 */
     nyuuinjyoukyou                                     VARCHAR     (1)                                                                 ,  /* 入院状況 */
     syuyouzaisiyouyoteiym                              VARCHAR     (6)                                                                 ,  /* 腫瘍剤使用予定年月 */
     kenpotaisyoukbn                                    VARCHAR     (1)                                                                 ,  /* 健保対象区分 */
     knptsgairytikenkbn                                 VARCHAR     (1)                                                                 ,  /* 健保対象外理由（治験）区分 */
     knptsgairysensinkbn                                VARCHAR     (1)                                                                 ,  /* 健保対象外理由（先進医療）区分 */
     knptsgairykknaimsynnyakukbn                        VARCHAR     (1)                                                                 ,  /* 健保対象外理由（国内未承認薬）区分 */
     knptsgairykyyhkkyhmsynnkbn                         VARCHAR     (1)                                                                 ,  /* 健保対象外理由（効果用法未承認）区分 */
     knptsgairysonotakbn                                VARCHAR     (1)                                                                 ,  /* 健保対象外理由（その他）区分 */
     knptsgairysonotanaiyou                             VARCHAR     (82)                                                                ,  /* 健保対象外理由（その他内容） */
     sibouymd                                           VARCHAR     (8)                                                                 ,  /* 死亡日 */
     siboubasyokbn                                      VARCHAR     (1)                                                                 ,  /* 死亡場所区分 */
     siboubasyo                                         VARCHAR     (82)                                                                ,  /* 死亡場所 */
     syougaikoteiymd                                    VARCHAR     (8)                                                                 ,  /* 障害固定日 */
     pmenkbn                                            VARCHAR     (1)                                                                 ,  /* Ｐ免区分 */
     pmenkoteiymd                                       VARCHAR     (8)                                                                 ,  /* Ｐ免固定日 */
     lnseikyuukbn                                       VARCHAR     (1)                                                                 ,  /* ＬＮ請求区分 */
     lnsiteihokenkngk                                   DECIMAL     (4)                                                                 ,  /* ＬＮ指定保険金額 */
     lnsiteihokenkngk$                                  VARCHAR     (10)                                                                ,  /* ＬＮ指定保険金額(通貨型) */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JT_SkJiyuu_Z ADD CONSTRAINT PK_SkJiyuu PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     seikyuurirekino                                          , /* 請求履歴番号 */
     uketukeno                                                  /* 受付番号 */
) ;
