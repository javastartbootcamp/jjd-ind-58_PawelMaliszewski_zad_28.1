INSERT INTO CATEGORY (name, description)
VALUES
    ('Elektronika', 'Coś dla każdego'),
    ('Meble', 'Niezbędne w każdym domu'),
    ('Przybory kuchenny', 'Niezastąpiona pomoc w kuchni');


INSERT INTO OFFER (title, description, img_Url, price, category_id)
VALUES
    ('Telewizor', 'Super telewizor o przekątnej 55 cali',
     'https://fastly.picsum.photos/id/60/1920/1200.jpg?hmac=fAMNjl4E_sG_WNUjdU39Kald5QAHQMh-_-TsIbbeDNI', '6000', 1),
    ('Kino domowe', 'Super kino wspaniały dźwięk',
     'https://fastly.picsum.photos/id/495/5000/3333.jpg?hmac=I_-GTpjt4wJi8vDzBnUel5s2GsvOLSzU5xXD4GOA8ic', '3500', 1),
    ('Stól drewniany', 'Idealny dla rodziny, sześć krzeseł w cenie',
     'https://fastly.picsum.photos/id/445/4256/2819.jpg?hmac=99qT1IPidZrzaXTgG1ixRRVwElWXUlNepU2k692G44c', '6000', 2),
    ('Zestaw przyborów kuchennych', 'Stylowy zestaw w dobrej cenie',
     'https://fastly.picsum.photos/id/490/5000/3306.jpg?hmac=3oE07HbI9nD9GkJ50fLHDdQXuSJjbBEK7K9n7ScL-2s', '550', 3);
