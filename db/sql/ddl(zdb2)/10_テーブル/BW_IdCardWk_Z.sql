CREATE TABLE BW_IdCardWk_Z (
     idkbn                                              VARCHAR     (2)                                                       NOT NULL  ,  /* ＩＤ区分 */
     idcd                                               VARCHAR     (6)                                                       NOT NULL  ,  /* ＩＤコード */
     tanmatusiyoukbn                                    VARCHAR     (1)                                                                 ,  /* 端末使用区分 */
     accesskbn                                          VARCHAR     (1)                                                                 ,  /* アクセス区分 */
     idnyuuryokusyanm                                   VARCHAR     (38)                                                                ,  /* ＩＤ入力者名 */
     kanjiidnyuuryokusyanm                              VARCHAR     (22)                                                                ,  /* 漢字ＩＤ入力者名 */
     idnyuuryokusyaseiymd                               VARCHAR     (8)                                                                 ,  /* ＩＤ入力者生年月日 */
     idnyuuryokusyanyuusyaymd                           VARCHAR     (8)                                                                 ,  /* ＩＤ入力者入社年月日 */
     syozokusosikicd                                    VARCHAR     (7)                                                                 ,  /* 所属組織コード */
     syozokusisyacd                                     VARCHAR     (3)                                                                 ,  /* 所属支社コード */
     syozokusibucd                                      VARCHAR     (3)                                                                 ,  /* 所属支部コード */
     idnyuuryokusyasikakucd                             VARCHAR     (5)                                                                 ,  /* ＩＤ入力者資格コード */
     idsdpsouhuhyouji                                   VARCHAR     (1)                                                                 ,  /* ＩＤＳＤＰ送付表示 */
     idcardsaisyuukousinymd                             VARCHAR     (8)                                                                 ,  /* ＩＤカード最終更新年月日 */
     idcardmukouymd                                     VARCHAR     (8)                                                                 ,  /* ＩＤカード無効年月日 */
     kaikeitantousyakbn                                 VARCHAR     (2)                                                                 ,  /* 会計担当者区分 */
     syanaiyokintantousyakbn                            VARCHAR     (2)                                                                 ,  /* 社内預金担当者区分 */
     jinjimynosyoukaihyj                                VARCHAR     (1)                                                                 ,  /* 人事・マイナンバー照会可能表示 */
     eisyokumynosyoukaihyj                              VARCHAR     (1)                                                                 ,  /* 営職・マイナンバー照会可能表示 */
     hudousanmynosyoukaihyj                             VARCHAR     (1)                                                                 ,  /* 不動産・マイナンバー照会可能表示 */
     kohomynosyoukaihyj                                 VARCHAR     (1)                                                                 ,  /* 個保・マイナンバー照会可能表示 */
     kihomynosyoukaihyj                                 VARCHAR     (1)                                                                 ,  /* 企保・マイナンバー照会可能表示 */
     kikantantoukbn                                     VARCHAR     (1)                                                                 ,  /* 機関担当区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BW_IdCardWk_Z ADD CONSTRAINT PK_IdCardWk PRIMARY KEY (
     idkbn                                                    , /* ＩＤ区分 */
     idcd                                                       /* ＩＤコード */
) ;
