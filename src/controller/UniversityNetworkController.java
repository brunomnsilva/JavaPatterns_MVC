package controller;

import model.Person;
import model.UniversityNetworkException;
import model.UniversityNetwork;
import view.UniversityNetworkUI;

/**
 * @author brunomnsilva
 */
public class UniversityNetworkController {

    private UniversityNetworkUI view;
    private UniversityNetwork model;

    public UniversityNetworkController(UniversityNetworkUI view, UniversityNetwork model) {
        this.view = view;
        this.model = model;

        /* binds actions to user interface*/
        this.view.setTriggers(this);

        /* bind observer */
        this.model.addObserver(this.view);
    }

    public void doAddPerson() {
        /* TODO */
    }

    public void doAddClassRelationShip() {
        try {
            String description = view.getRelationShipDescriptionAdd();
            String id1 = view.getRelationshipFirstPersonId();
            String id2 = view.getRelationshipSecondPersonId();

            if(id1 == null || id2 == null) {
                view.displayError("You must select the IDs.");
                return;
            }

            if(description.trim().isEmpty()) {
                view.displayError("You must provide a description.");
                return;
            }

            model.addClassRelationship(description, Integer.valueOf(id1), Integer.valueOf(id2));

            view.clearError();
            view.clearControls();

        } catch (UniversityNetworkException e) {
            this.view.displayError( e.getMessage() );
        } catch (NumberFormatException e2) {
            view.displayError("The ID must be an integer number.");
        }
    }

    public void doAddGroupRelationShip() {
        try {
            String description = view.getRelationShipDescriptionAdd();
            String id1 = view.getRelationshipFirstPersonId();
            String id2 = view.getRelationshipSecondPersonId();

            if(id1 == null || id2 == null) {
                view.displayError("You must select the IDs.");
                return;
            }

            if(description.trim().isEmpty()) {
                view.displayError("You must provide a description.");
                return;
            }

            model.addGroupRelationship(description, Integer.valueOf(id1), Integer.valueOf(id2));

            view.clearError();
            view.clearControls();

        } catch (UniversityNetworkException e) {
            this.view.displayError( e.getMessage() );
        } catch (NumberFormatException e2) {
            view.displayError("The ID must be an integer number.");
        }
    }

    public void doRemoveRelationShip() {
        try {
            String id1 = view.getRelationshipFirstPersonId();
            String id2 = view.getRelationshipSecondPersonId();

            model.removeRelation(Integer.valueOf(id1), Integer.valueOf(id2));

            view.clearError();
            view.clearControls();

        } catch (UniversityNetworkException e) {
            this.view.displayError( e.getMessage() );
        } catch (NumberFormatException e2) {
            view.displayError("The ID must be an integer number.");
        }
    }
}
