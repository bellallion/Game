package com.example.game;

public class Story {
    //    сюжет
    private Situation start_story;
    public Situation current_situation;
    public Student student = new Student();

    public Story() {
        start_story = new Situation("Будильник", "Время 6:30. Пора вставать, но вчера вы легли поздно. Что будете делать?",
                "Эх… Подъём! Выпью-ка кофе )",
                "Ой ну посплю ещё 10 минут, ничего страшного не случится.",
                "Я хочу спать. Я буду спать.",
                3, new int[]{10, 0, -10}, new int[]{-10,10,10}, new int[]{-10,0,10}, student);
        start_story.direction[0] = new Situation("Сборы","Вы проснулись вовремя. Утренняя рутина завершена, но ещё осталось время до выхода. Чем займётесь?",
                "У нас будет лекция. Просмотрю материал, чтобы не теряться на ней.",
                "Положу еду в ланчбокс, который возьму с собой.",
                "Почитаю/посмотрю что-нибудь.",
                3,new int[]{10,0,0},new int[]{-10,0,0},new int[]{0,0,10}, student);
        start_story.direction[1] = new Situation("Опоздание.", "О нет! Вы поспали не 10, а 40 минут! Теперь придётся поторопиться, чтобы успеть на пары.",
                "Я всё успею. Быстренько соберусь сейчас. Закину бутер в рюкзак.",
                "Лектор Ринчино…лучше не пойду.",
                "Спокойно соберусь, немного опоздаю.",
                3, new int[]{0,-10,-10},new int[]{-10,0,0},new int[]{0,10,10}, student);
        start_story.direction[2] = new Situation("Пробуждение","Поздравляю, вы выспались. Ваши следующие действия?",
                "Ну пойду прогуляюсь что ли…",
                "А теперь стоит поехать на пары.  Не стоит всё пропускать.",
                "Раз полдня пропустил, то можно и не ходить.",
                3,new int[]{-10,10,-10},new int[]{-10,-10,0},new int[]{10,0,10}, student);
                start_story.direction[0].direction[0] = new Situation("Лекция","Вы на лекции. Ничего не понимаете. Что же делать?",
                        "Буду конспектировать.",
                        "Ой… тут друзья ТАКОЕ обсуждают…",
                        "Сон, милый сооон…",
                        3,new int[]{-10,-10,-15},new int[]{-10,0,10},new int[]{0,10,0}, student);
                start_story.direction[0].direction[1] = start_story.direction[0].direction[0];
                start_story.direction[0].direction[2] = start_story.direction[0].direction[0];
                start_story.direction[1].direction[0] = start_story.direction[0].direction[0];
                start_story.direction[1].direction[1] = new Situation("Отдых","Столько свободного времени… Что же делать?",
                        "Буду звонить одногруппникам ВУХАХА",
                        "Поделаю что-нибудь по учёбе.",
                        "Зачем что-то делать?",
                        3,new int[]{-10,10, 0}, new int[]{0,-10,0},new int[]{10,0,0}, student);
                start_story.direction[1].direction[2] = start_story.direction[0].direction[0];
                start_story.direction[2].direction[0] = start_story.direction[1].direction[1];
                start_story.direction[2].direction[1] = start_story.direction[1].direction[1];
                start_story.direction[2].direction[2] = start_story.direction[1].direction[1];
                start_story.direction[0].direction[0].direction[0] = new Situation("Обед","Время 12:10. Пора кушать. Какое примешь решение?",
                        "Встану в очередь в столовку…эх рискую опоздать на пары…",
                        "У меня же есть еда с собой. Сейчас как поем!",
                        "Зачем есть? Не буду.",
                        3,new int[]{-10,0,0}, new int[]{10,10,-10}, new int[]{0,10,-10}, student);
                start_story.direction[0].direction[0].direction[1] = start_story.direction[0].direction[0].direction[0];
                start_story.direction[0].direction[0].direction[2] = start_story.direction[0].direction[0].direction[0];
                start_story.direction[0].direction[0].direction[0].direction[0] = new Situation("Практика",
                        "Началась пара. Практика. Что будешь делать?",
                        "Сяду на последний ряд. Посплю.",
                        "Буду усердно работать, нужно закрепить материал.",
                        "Поеду-ка я домой…",
                        3, new int[]{-10,10,-10}, new int[]{10,-10,0}, new int[]{0,0,10}, student);
                start_story.direction[0].direction[0].direction[0].direction[1] = start_story.direction[0].direction[0].direction[0].direction[0];
                start_story.direction[0].direction[0].direction[0].direction[2] = start_story.direction[0].direction[0].direction[0].direction[0];
                start_story.direction[0].direction[0].direction[0].direction[0].direction[0] = new Situation("Дом","Уже вечер. Вы дома. Чем займетесь?",
                        "Лягу спать. Нужно восстановить силы.",
                        "Нужно повторить материал! Поучусь немного, а потом лягу спать.",
                        "Посмотрю фильм перед сном.",
                        0, new int[]{0,10,0}, new int[]{20,-10,0}, new int[]{10,0,10}, student);
                start_story.direction[0].direction[0].direction[0].direction[0].direction[1] = start_story.direction[0].direction[0].direction[0].direction[0].direction[0];
                start_story.direction[0].direction[0].direction[0].direction[0].direction[2] = start_story.direction[0].direction[0].direction[0].direction[0].direction[0];
                start_story.direction[1].direction[1].direction[0] = new Situation("Староста",
                        "Вы также позвонили старосте. Он разозлился на вас. Теперь вас не будут отмечать на парах.",
                        "Беда! Нужно срочно извиниться.",
                        "«Из МИРЭА невозможно отчислиться». Всё будет хорошо.",
                        "Идиот! Никогда он мне не нравился.",
                         3, new int[]{10,0,-10}, new int[]{-5,0,0}, new int[]{-10,0,-10}, student);
                start_story.direction[1].direction[1].direction[0].direction[0] = start_story.direction[0].direction[0].direction[0].direction[0].direction[0];
                start_story.direction[1].direction[1].direction[0].direction[1] = start_story.direction[0].direction[0].direction[0].direction[0].direction[0];
                start_story.direction[1].direction[1].direction[0].direction[2] = start_story.direction[0].direction[0].direction[0].direction[0].direction[0];
                start_story.direction[1].direction[1].direction[1] =  start_story.direction[0].direction[0].direction[0].direction[0].direction[0];
                start_story.direction[1].direction[1].direction[2] =  start_story.direction[0].direction[0].direction[0].direction[0].direction[0];
                start_story.direction[2].direction[0] =  start_story.direction[1].direction[1];
                start_story.direction[2].direction[1] =  start_story.direction[0].direction[0].direction[0].direction[0];
                start_story.direction[2].direction[2] =  start_story.direction[1].direction[1];

        current_situation = start_story;
    }
}
