package com.ite53330ga.easymedandroid.db;

import android.os.Parcel;
import android.os.Parcelable;

import com.ite53330ga.easymedandroid.R;

import java.util.ArrayList;
import java.util.List;

public class DummyDatabase {
    private static final ArrayList<SymptomDbItem> dbItems = new ArrayList<>();

    static {
        dbItems.add(new SymptomDbItem(100,"Abdominal Pain", "Abdominal pain is pain that you feel anywhere between your chest and groin. This is often referred to as the stomach region or belly.F", R.drawable.ic_abdominal_pain));
        dbItems.add(new SymptomDbItem(101,"Acne", "The occurrence of inflamed or infected sebaceous glands in the skin; in particular, a condition characterized by red pimples on the face, prevalent chiefly among teenagers.", R.drawable.ic_acne));
        dbItems.add(new SymptomDbItem(102,"Body pain", "Pain is an unpleasant sensation in the body that is triggered by the nervous system. The onset of body pain can occur suddenly or slowly, depending on many factors, (e.g. environmental, biological, emotional, cognitive, etc.) Each individual is the best judge of the severity and frequency of his or her body pain.", R.drawable.ic_body_pain));
        dbItems.add(new SymptomDbItem(103,"Pain around bone", "While bone pain is most likely due to decreased bone density or an injury to your bone, it can also be a sign of a serious underlying medical condition. Bone pain or tenderness could be the result of infection, an interruption in the blood supply, or cancer. These conditions require immediate medical attention.", R.drawable.ic_bone));
        dbItems.add(new SymptomDbItem(104,"Chest pain", "Chest pain is discomfort or pain that you feel anywhere along the front of your body between your neck and upper abdomen.", R.drawable.ic_chest_pain_or_pressure));
        dbItems.add(new SymptomDbItem(105,"Conjunctivitis", "Conjunctivitis is a condition that occurs when the conjunctiva (a thin layer of cells covering the front of your eyes) becomes inflamed. The three most common causes of this inflammation are: infection (infective conjunctivitis) an allergic reaction (allergic conjunctivitis)Apr", R.drawable.ic_conjuctivitis));
        dbItems.add(new SymptomDbItem(106,"Constipation", "Constipation is generally described as having fewer than three bowel movements a week. Though occasional constipation is very common, some people experience chronic constipation that can interfere with their ability to go about their daily tasks.", R.drawable.ic_constipation));
        dbItems.add(new SymptomDbItem(107,"Cough", "\n" +
                "A cough is your body's way of responding when something irritates your throat or airways. An irritant stimulates nerves that send a message to your brain. The brain then tells muscles in your chest and abdomen to push air out of your lungs to force out the irritant. An occasional cough is normal and healthy.", R.drawable.ic_cough));
        dbItems.add(new SymptomDbItem(108,"Diarrhea", "Diarrhea — loose, watery and possibly more-frequent bowel movements — is a common problem. It may be present alone or be associated with other symptoms, such as nausea, vomiting, abdominal pain or weight loss. Luckily, diarrhea is usually short-lived, lasting no more than a few days.", R.drawable.ic_diarrhea));
        dbItems.add(new SymptomDbItem(109,"Dizziness", "Overview. Dizziness is a term used to describe a range of sensations, such as feeling faint, woozy, weak or unsteady. Dizziness that creates the false sense that you or your surroundings are spinning or moving is called vertigo. Dizziness is one of the more common reasons adults visit their doctors.", R.drawable.ic_dizziness));
        dbItems.add(new SymptomDbItem(110,"Gastric", "\n" +
                "Gastritis is a general term for a group of conditions with one thing in common: Inflammation of the lining of the stomach. The inflammation of gastritis is most often the result of infection with the same bacterium that causes most stomach ulcers or the regular use of certain pain relievers.", R.drawable.ic_gastric));
        dbItems.add(new SymptomDbItem(111,"Herpes", "Any of a group of viral diseases caused by herpes viruses, affecting the skin (often with blisters) or the nervous system.", R.drawable.ic_herpes));
        dbItems.add(new SymptomDbItem(112,"Kidney pain", "One of a pair of organs in the abdomen. The kidneys remove waste and extra water from the blood (as urine) and help keep chemicals (such as sodium, potassium, and calcium) balanced in the body. The kidneys also make hormones that help control blood pressure and stimulate bone marrow to make red blood cells.", R.drawable.ic_kidney));
        dbItems.add(new SymptomDbItem(113,"Lack of appetite", "A decreased appetite is when your desire to eat is reduced. The medical term for a loss of appetite is anorexia.", R.drawable.ic_lack_of_appetite));
        dbItems.add(new SymptomDbItem(114,"Loss of color in toes", "Purple or blue feet may be a sign of an underlying health condition. Some possible causes of foot discoloration include injuries, Raynaud's disease.", R.drawable.ic_loss_of_colour_in_toes));
        dbItems.add(new SymptomDbItem(115,"Loss of sense of taste", "The term “ageusia” refers to the loss of sense of taste. Ageusia may be caused by infections, certain medications, nutritional deficiencies or other factors. Loss of sense of taste is also a possible symptom of COVID-19.", R.drawable.ic_loss_of_sense_of_taste));
        dbItems.add(new SymptomDbItem(116,"Lower back pain", "Low back pain is pain, muscle tension, or stiffness localized below the costal margin and above the inferior gluteal folds, with or without sciatica, and is defined as chronic when it persists for 12 weeks or more.", R.drawable.ic_lower_back_pain));
        dbItems.add(new SymptomDbItem(117,"Migraine", "A migraine is usually a moderate or severe headache felt as a throbbing pain on 1 side of the head. Many people also have symptoms such as feeling sick, being sick and increased sensitivity to light or sound. Migraine is a common health condition, affecting around 1 in every 5 women and around 1 in every 15 men.", R.drawable.ic_migraine));
        dbItems.add(new SymptomDbItem(118,"Muscle pain", "Myalgia describes muscle aches and pain, which can involve ligaments, tendons and fascia, the soft tissues that connect muscles, bones and organs. Injuries, trauma, overuse, tension, certain drugs and illnesses can all bring about myalgia.", R.drawable.ic_muscle_pain));
        dbItems.add(new SymptomDbItem(119,"Difficulty breathing", "Shortness of breath — known medically as dyspnea — is often described as an intense tightening in the chest, air hunger, difficulty breathing, breathlessness or a feeling of suffocation.", R.drawable.ic_pneumonia));
        dbItems.add(new SymptomDbItem(120,"Rashes", "\n" +
                "This could be caused by an allergic reaction or an infection. Examples of rashes caused by infection include scarlet fever, measles, mononucleosis, and shingles. The rash is sudden and spreads rapidly. This could be the result of an allergy.", R.drawable.ic_rash));
        dbItems.add(new SymptomDbItem(121,"Runny nose", "A runny nose is excess nasal drainage. It may be a thin clear fluid, thick mucus or something in between. The drainage may run out of your nose, down the back of your throat or both. The terms \"rhinorrhea\" and \"rhinitis\" are often used to refer to a runny nose.", R.drawable.ic_runny_nose));
        dbItems.add(new SymptomDbItem(122,"Weakness", "The state or quality of being weak; lack of strength, firmness, vigor, or the like; feebleness. an inadequate or defective quality, as in a person's character; slight fault or defect: to show great sympathy for human weaknesses.", R.drawable.ic_sick));
        dbItems.add(new SymptomDbItem(123,"Sneezing", "Sneezing is caused by irritation to the mucous membranes of the nose or throat. It can be very bothersome, but is rarely a sign of a serious problem. Sneezing can be due to: Allergy to pollen (hay fever), mold, dander, dust. Breathing in corticosteroids (from certain nose sprays)Ma", R.drawable.ic_sneezing));
        dbItems.add(new SymptomDbItem(124,"Sore throat", "A sore throat is pain, scratchiness or irritation of the throat that often worsens when you swallow. The most common cause of a sore throat (pharyngitis) is a viral infection, such as a cold or the flu. A sore throat caused by a virus resolves on its own.", R.drawable.ic_sore_throat));
        dbItems.add(new SymptomDbItem(125,"Stomach bug", "Viral gastroenteritis is an infection of your intestines that typically causes watery diarrhea, pain or cramping in your abdomen, nausea or vomiting, and sometimes fever. Viral gastroenteritis is caused by viruses link. Viruses invade normal cells in your body.", R.drawable.ic_stomach_bug));
        dbItems.add(new SymptomDbItem(126,"Tired", "Tired, exhausted, fatigued, wearied, weary suggest a condition in which a large part of one's energy and vitality has been consumed.", R.drawable.ic_tired));
        dbItems.add(new SymptomDbItem(127,"Upper back pain", "Upper back pain can occur anywhere between the base of the neck and the bottom of the rib cage. Upper back pain may be caused by injuries or fractures, poor posture, disk problems or other issues, such as arthritis. People with mild to moderate upper back pain can usually manage their symptoms at home.", R.drawable.ic_upper_back_pain));
        dbItems.add(new SymptomDbItem(128,"Vomiting", "To eject some or all of the contents of the stomach through the mouth.", R.drawable.ic_vomiting));
    }

    public List<SymptomDbItem> getDummyData() {
        return dbItems;
    }

    public static class SymptomDbItem implements Parcelable {

        public SymptomDbItem(int id, String name, String desc, int icon) {
            this.name = name;
            this.desc = desc;
            this.icon = icon;
            this.id = id;
        }
        public int id;
        public String name;
        public String desc;
        public int icon;

        protected SymptomDbItem(Parcel in) {
            id = in.readInt();
            name = in.readString();
            desc = in.readString();
            icon = in.readInt();
        }

        public static final Creator<SymptomDbItem> CREATOR = new Creator<SymptomDbItem>() {
            @Override
            public SymptomDbItem createFromParcel(Parcel in) {
                return new SymptomDbItem(in);
            }

            @Override
            public SymptomDbItem[] newArray(int size) {
                return new SymptomDbItem[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(name);
            parcel.writeString(desc);
            parcel.writeInt(icon);
        }

        @Override
        public String toString() {
            return "SymptomDbItem{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", desc='" + desc + '\'' +
                    ", icon=" + icon +
                    '}';
        }
    }
}


/*
*
    static {
        dbItems.add(new SymptomDbItem(100,R.string.db_abdominal_pain, R.string.db_abdominal_pain_desc, R.drawable.ic_abdominal_pain));
        dbItems.add(new SymptomDbItem(101,R.string.db_acne, R.string.db_acne_desc, R.drawable.ic_acne));
        dbItems.add(new SymptomDbItem(102,R.string.db_body_pain, R.string.db_body_pain_desc, R.drawable.ic_body_pain));
        dbItems.add(new SymptomDbItem(103,R.string.db_pain_around_bone, R.string.db_pain_around_bone_desc, R.drawable.ic_bone));
        dbItems.add(new SymptomDbItem(104,R.string.db_chest_pain, R.string.db_chest_pain_desc, R.drawable.ic_chest_pain_or_pressure));
        dbItems.add(new SymptomDbItem(105,R.string.db_conjunctivitis, R.string.db_conjunctivitis_dsc, R.drawable.ic_conjuctivitis));
        dbItems.add(new SymptomDbItem(106,R.string.db_constipation, R.string.db_constipation_desc, R.drawable.ic_constipation));
        dbItems.add(new SymptomDbItem(107,R.string.db_cough, R.string.db_cough_desc, R.drawable.ic_cough));
        dbItems.add(new SymptomDbItem(108,R.string.db_diarrhea, R.string.db_diarrhea_desc, R.drawable.ic_diarrhea));
        dbItems.add(new SymptomDbItem(109,R.string.db_dizziness, R.string.db_dizziness_desc, R.drawable.ic_dizziness));
        dbItems.add(new SymptomDbItem(110,R.string.db_gastric, R.string.db_gastric_desc, R.drawable.ic_gastric));
        dbItems.add(new SymptomDbItem(111,R.string.db_herpes, R.string.db_herpes_desc, R.drawable.ic_herpes));
        dbItems.add(new SymptomDbItem(112,R.string.db_kidney_pain, R.string.db_kidney_pain_desc, R.drawable.ic_kidney));
        dbItems.add(new SymptomDbItem(113,R.string.db_lack_appetite, R.string.db_lack_appetite_desc, R.drawable.ic_lack_of_appetite));
        dbItems.add(new SymptomDbItem(114,R.string.db_loss_of_color_toes, R.string.db_loss_of_color_toes_desc, R.drawable.ic_loss_of_colour_in_toes));
        dbItems.add(new SymptomDbItem(115,R.string.db_loss_of_sense_of_taste, R.string.db_loss_of_sense_of_taste_desc, R.drawable.ic_loss_of_sense_of_taste));
        dbItems.add(new SymptomDbItem(116,R.string.db_lower_back_pain, R.string.db_lower_back_pain_desc, R.drawable.ic_lower_back_pain));
        dbItems.add(new SymptomDbItem(117,R.string.db_migraine, R.string.db_migraine_desc, R.drawable.ic_migraine));
        dbItems.add(new SymptomDbItem(118,R.string.db_muscle_pain, R.string.db_muscle_pain_desc, R.drawable.ic_muscle_pain));
        dbItems.add(new SymptomDbItem(119,R.string.db_difficulty_breathing, R.string.db_difficulty_breathing_desc, R.drawable.ic_pneumonia));
        dbItems.add(new SymptomDbItem(120,R.string.db_rash, R.string.db_rash_desc, R.drawable.ic_rash));
        dbItems.add(new SymptomDbItem(121,R.string.db_runny_nose, R.string.db_runny_nose_desc, R.drawable.ic_runny_nose));
        dbItems.add(new SymptomDbItem(122,R.string.db_weakness, R.string.db_weakness_desc, R.drawable.ic_sick));
        dbItems.add(new SymptomDbItem(123,R.string.db_sneezing, R.string.db_sneezing_desc, R.drawable.ic_sneezing));
        dbItems.add(new SymptomDbItem(124,R.string.db_sore_throat, R.string.db_sore_throat_desc, R.drawable.ic_sore_throat));
        dbItems.add(new SymptomDbItem(125,R.string.db_stomach_bug, R.string.db_stomach_bug_desc, R.drawable.ic_stomach_bug));
        dbItems.add(new SymptomDbItem(126,R.string.db_tired, R.string.db_tired_desc, R.drawable.ic_tired));
        dbItems.add(new SymptomDbItem(127,R.string.db_upper_back_pain, R.string.db_upper_back_pain_desc, R.drawable.ic_upper_back_pain));
        dbItems.add(new SymptomDbItem(128,R.string.db_vomiting, R.string.db_vomiting_desc, R.drawable.ic_vomiting));
    }
*
* */