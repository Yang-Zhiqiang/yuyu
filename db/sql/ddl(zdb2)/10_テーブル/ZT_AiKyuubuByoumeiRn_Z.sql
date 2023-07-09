CREATE TABLE ZT_AiKyuubuByoumeiRn_Z (
     zrnbyoumeitourokuno                                CHAR        (6)                                                       NOT NULL  ,  /* （連携用）病名登録番号 */
     zrnbyoumei                                         GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）病名 */
     zrnbyoumeizenkaku                                  GRAPHIC     (100)                                                     NOT NULL  ,  /* （連携用）病名全角 */
     zrnbyoumeihurigana                                 CHAR        (60)                                                      NOT NULL  ,  /* （連携用）病名フリガナ */
     zrnbyoumeihuriganakensaku                          CHAR        (60)                                                      NOT NULL  ,  /* （連携用）病名フリガナ検索用 */
     zrnbyoumeicd                                       CHAR        (4)                                                       NOT NULL  ,  /* （連携用）病名コード */
     zrnbyoumeibuicd                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）病名部位コード */
     zrngaitoukbn1                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）該当区分１ */
     zrngaitoukbn2                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）該当区分２ */
     zrngaitoukbn3                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）該当区分３ */
     zrngaitoukbn4                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）該当区分４ */
     zrngaitoukbn5                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）該当区分５ */
     zrntyuuimongon                                     GRAPHIC     (35)                                                      NOT NULL     /* （連携用）注意文言 */
)
;

ALTER TABLE ZT_AiKyuubuByoumeiRn_Z ADD CONSTRAINT PK_AiKyuubuByoumeiRn PRIMARY KEY (
     zrnbyoumeitourokuno                                        /* （連携用）病名登録番号 */
) ;
